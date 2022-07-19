package oscar.carbon_app.service;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import oscar.carbon_app.data.models.Collaborateur;
import oscar.carbon_app.data.models.Voiture;
import oscar.carbon_app.data.payloads.response.CalculResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.List;

@Service
public class CalculServiceImpl {

    private final CollaborateurServiceImpl collabService;
    private final PerServiceImpl perService;
    private final HashMap<String, Double> emissions;

    public CalculServiceImpl(CollaborateurServiceImpl collabService, PerServiceImpl perService) throws IOException {
        this.collabService = collabService;
        this.perService = perService;

        //unite motorisation: kgCO2e/km
        //unite  tramway/bus: kgCO2e/Passager.Km
        //unite  teletravail: kgCO2/an pour 1 jour de télétravail par semaine
        //unit        papier: kgCO2e/Kg
        File resource = new ClassPathResource("fe.json").getFile();
        String jsonStr = new String(Files.readAllBytes(resource.toPath()));
        emissions = new ObjectMapper().readValue(jsonStr,new TypeReference<HashMap<String,Double>>() {});
    }

    public CalculResponse calculBilan(Integer per_id){

        List<Collaborateur> collabsByPer = collabService.getAllCollaborateursByPerID(per_id);
        double emissions_voiture_semaine = 0;
        double emissions_bus_semaine = 0;
        double emissions_tramway_semaine = 0;
        double emissions_teletravail_annee = 0;

        for(Collaborateur collab : collabsByPer){

            //calcul effet rebond teletravail
            emissions_teletravail_annee += collab.getNb_jours_teletravail_semaine()*emissions.get("teletravail");

            //Calcul des déplacements
            emissions_bus_semaine += (collab.getDistance_maison_travail()*emissions.get("bus")*2*collab.getNb_jours_bus_semaine())/20;

            emissions_tramway_semaine += collab.getDistance_maison_travail()*emissions.get("metro-tramway")*2*collab.getNb_jours_tramway_semaine();

            for (Voiture v:collab.getVoitures()) {
                switch (v.getMotorisation().getMotorisation()){
                    case "Diesel" :
                        emissions_voiture_semaine += (collab.getDistance_maison_travail()*emissions.get("motorisation-diesel")*2*collab.getNb_jours_voiture_semaine());
                        break;
                    case "GPL" :
                        emissions_voiture_semaine += (collab.getDistance_maison_travail()*emissions.get("motorisation-GPL")*2*collab.getNb_jours_voiture_semaine());
                        break;
                    case "Hybride" :
                        emissions_voiture_semaine += (collab.getDistance_maison_travail()*emissions.get("motorisation-moyenne")*2*collab.getNb_jours_voiture_semaine());
                        break;
                    case "Essence" :
                        emissions_voiture_semaine += (collab.getDistance_maison_travail()*emissions.get("motorisation-essence")*2*collab.getNb_jours_voiture_semaine());
                        break;
                    case "E85" :
                        emissions_voiture_semaine += (collab.getDistance_maison_travail()*emissions.get("motorisation-E85")*2*collab.getNb_jours_voiture_semaine());
                        break;
                }
            }
        }

        //aglomération des résultats
        CalculResponse res = new CalculResponse();

        int SEMAINES_OUVRES = 45;
        double emissions_voiture_annee = emissions_voiture_semaine * SEMAINES_OUVRES;
        double emissions_bus_annee = emissions_bus_semaine * SEMAINES_OUVRES;
        double emissions_tramway_annee = emissions_tramway_semaine * SEMAINES_OUVRES;

        double emissions_transport_annee = emissions_voiture_annee + emissions_bus_annee + emissions_tramway_annee; //ajouter les prochains calculs
        double emissions_totales_teletravail = emissions_teletravail_annee; //+dechets
        double emissions_collab_annee = emissions_transport_annee + emissions_totales_teletravail;
        double emissions_totales_annee = emissions_collab_annee; //ajouter per et projet

        //appliquer la fonction UpscaleResultat sur chaque
            //res.setEmissions_totales(UpscaleResultat(emissions_totales_annee, collabsByPer.size(),per_id));
        res.setEmissions_totales(emissions_totales_annee);
        res.setEmissions_totales_collab(emissions_collab_annee);
        res.setEmissions_totales_teletravail(emissions_totales_teletravail);
        res.setEmissions_totales_transports(emissions_transport_annee);
        res.setEmissions_voiture(emissions_voiture_annee);
        res.setEmissions_bus(emissions_bus_annee);
        res.setEmissions_tramway(emissions_tramway_annee);

        return res;
    }

    public double UpscaleResultat(double value, int nbFormulairesCollabReel, int per_id){
        //moyenne_emissions = les émissions d'un collaborateur en moyenne
        double moyenne_emissions = value / nbFormulairesCollabReel;

        //la vraie valeur  + (un collab * le nombre de collabs fictifs à remplir)
        return value + moyenne_emissions * (perService.getSitePerByID(per_id).getNb_collabs() - nbFormulairesCollabReel);
    }

    public void UpdateFE(){
        //conserver le tableau emissions
        //new hashmap
        //api ademe pour chaque valeur -> hashmap
        //convert hashmap en string json
        //vider le fichier fe.json et le remplir avec nouvelle string
        //renvoyer message text avec les nouvelles valeurs, et indiqué les différences sur les anciennes
    }
}