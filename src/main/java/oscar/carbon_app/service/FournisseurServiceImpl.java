package oscar.carbon_app.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import oscar.carbon_app.data.models.Fournisseur_elec;
import oscar.carbon_app.data.models.Fournisseur_gaz;
import oscar.carbon_app.data.repository.ElecRepository;
import oscar.carbon_app.data.repository.GazRepository;

import java.util.List;

@Service
public class FournisseurServiceImpl {

    @Autowired
    GazRepository repoGaz;

    @Autowired
    ElecRepository repoElec;

    public List<Fournisseur_elec> getAllFournisseursElec(){
        return repoElec.findAll();
    }

    public List<Fournisseur_gaz> getAllFournisseursGaz(){
        return repoGaz.findAll();
    }
}
