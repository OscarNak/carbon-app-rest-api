package oscar.carbon_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import oscar.carbon_app.data.models.Collaborateur;
import oscar.carbon_app.data.models.Voiture;
import oscar.carbon_app.data.payloads.request.CollaborateurDto;
import oscar.carbon_app.data.payloads.request.VoitureDto;
import oscar.carbon_app.data.payloads.response.MessageResponse;
import oscar.carbon_app.data.repository.*;
import oscar.carbon_app.exception.ResourceNotFoundException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CollaborateurServiceImpl implements CollaborateurService {

    @Autowired
    CollaborateurRepository repo;
    @Autowired
    PerRepository repoPer;

    @Autowired
    ElecRepository repoElec;

    @Autowired
    GazRepository repoGaz;

    @Autowired
    MotorisationRepository repoMoto;

    @Autowired
    TypeRepository repoType;


    /**
     * @param dto Objet json reçu dans la requête.
     * @return un objet réponse
     */
    @Override
    public MessageResponse createCollaborateur(CollaborateurDto dto) {

        System.out.println(dto);
        Collaborateur collab = new Collaborateur();
        collab.setPer(repoPer.getById(dto.getId_per()));
        collab.setDate_saisie(new SimpleDateFormat("yyy-MM-dd").format(new Date()));
        collab.setDistance_maison_travail(dto.getDistance_maison_travail());
        collab.setNb_jours_teletravail_semaine(dto.getNb_jours_teletravail_semaine());
        collab.setNb_jours_voiture_semaine(dto.getNb_jours_voiture_semaine());
        collab.setNb_jours_bus_semaine(dto.getNb_jours_bus_semaine());
        collab.setNb_jours_tramway_semaine(dto.getNb_jours_tramway_semaine());
        collab.setConso_elec_kwh_mois(dto.getConso_elec_kwh_mois());
        collab.setConso_gaz_kwh_mois(dto.getConso_gaz_kwh_mois());
        collab.setConso_eau_m3_mois(dto.getConso_eau_m3_mois());
        collab.setDechets_kg_semaine(dto.getDechets_kg_semaine());
        collab.setDechets_recyclage_kg_semaine(dto.getDechets_recyclage_kg_semaine());

        List<Voiture> listeVoitures = new ArrayList<>();
        for (VoitureDto v : dto.getVoitures()){
            Voiture vv = new Voiture();
            vv.setAge_voiture(v.getAge());
            vv.setMotorisation(repoMoto.getById(v.getId_motorisation()));
            vv.setType(repoType.getById(v.getId_type()));
            listeVoitures.add(vv);
        }

        collab.setVoitures(listeVoitures);
        repo.save(collab);



        //créer un objet collab, et lui donner les properties du dto
        //récupérer un objet SitePer selon l'id, et l'ajouter dans l'objet collab
        //pareil avec fournisseur_gaz, fournisseur_elec

        //transformer la liste des voituresDto en liste d'objet voiture
        //ajouter cette nouvelle liste à l'objet collab

        //sauvegarder le collab dans la base


        return new MessageResponse("Enregistrement validé");
    }

    /**
     * @param collaborateurId L'identifiant du collaborateur souhaité.
     * @return un objet du collaborateur demandé.
     */
    @Override
    public Collaborateur getCollaborateur(Integer collaborateurId) throws ResourceNotFoundException {
        return repo.findById(collaborateurId)
                .orElseThrow(() -> new ResourceNotFoundException("Collaborateur","id",collaborateurId));
    }

    /**
     * @return la liste des collaborateurs présents dans la bdd.
     */
    @Override
    public List<Collaborateur> getAllCollaborateurs() {
        return repo.findAll();
    }

    public List<Collaborateur> getAllCollaborateursByPerID(Integer per_id){
        return repo.findCollaborateursByPerID(per_id);
    }
}
