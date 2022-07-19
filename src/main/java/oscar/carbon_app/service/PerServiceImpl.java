package oscar.carbon_app.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import oscar.carbon_app.data.models.SitePer;
import oscar.carbon_app.data.payloads.request.SitePerDto;
import oscar.carbon_app.data.payloads.response.MessageResponse;
import oscar.carbon_app.data.repository.ElecRepository;
import oscar.carbon_app.data.repository.GazRepository;
import oscar.carbon_app.data.repository.PerRepository;

import java.util.List;

@Service
public class PerServiceImpl implements PerService{

    @Autowired
    PerRepository repoPer;

    @Autowired
    ElecRepository repoElec;

    @Autowired
    GazRepository repoGaz;

    public List<SitePer> getAllSitesPer(){
        return repoPer.findAll();
    }

    public MessageResponse createPerForm(SitePerDto dto) {
        //todo
        return new MessageResponse("Enregistrement validé");
    }

    public SitePer getSitePerByID(Integer id){
        return repoPer.getById(id);
    }

    public String getLastEntryDate(Integer id_per) {
        SitePer monSite = repoPer.getById(id_per);
        return monSite.getDate_saisie();
    }

    public MessageResponse updateSitePer(SitePerDto dto) {
        SitePer monSite = repoPer.getById(dto.getId_per());

        if(monSite.getFElec().getId() != dto.getId_fournisseur_elec()){
            monSite.setFElec(repoElec.getById(dto.getId_fournisseur_elec()));
        }

        if(monSite.getFGaz().getId() != dto.getId_fournisseur_gaz()){
            monSite.setFGaz(repoGaz.getById(dto.getId_fournisseur_gaz()));
        }

        //modifications
        monSite.setConso_elec_kwh_mois(dto.getConso_elec_kwh_mois());
        monSite.setConso_gaz_kwh_mois(dto.getConso_gaz_kwh_mois());
        monSite.setConso_eau_m3_mois(dto.getConso_eau_m3_mois());
        monSite.setDechets_kg_semaine(dto.getDechets_kg_semaine());
        monSite.setDechets_recyclage_kg_semaine(dto.getDechets_recyclage_kg_semaine());
        monSite.setConso_papier_kilo_semaine(dto.getConso_papier_kilo_semaine());
        monSite.setNb_collabs(dto.getNb_collabs());

        repoPer.save(monSite);
        return new MessageResponse("Enregistrement validé");
    }
}
