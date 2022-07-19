package oscar.carbon_app.web;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import oscar.carbon_app.data.models.Fournisseur_elec;
import oscar.carbon_app.data.models.Fournisseur_gaz;
import oscar.carbon_app.service.FournisseurServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/v1/fournisseur")
@CrossOrigin
public class FournisseurController {

    private final FournisseurServiceImpl fournisseurService;

    public FournisseurController(FournisseurServiceImpl fournisseurService) {
        this.fournisseurService = fournisseurService;
    }

    @GetMapping("/gaz/all")
    public List<Fournisseur_gaz> getAllFournisseursGaz(){
        return fournisseurService.getAllFournisseursGaz();
    }

     @GetMapping("/elec/all")
    public List<Fournisseur_elec> getAllFournisseursElec(){
        return fournisseurService.getAllFournisseursElec();
     }
}
