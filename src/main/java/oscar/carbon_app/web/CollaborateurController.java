package oscar.carbon_app.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import oscar.carbon_app.data.models.Collaborateur;
import oscar.carbon_app.data.payloads.request.CollaborateurDto;
import oscar.carbon_app.data.payloads.response.MessageResponse;
import oscar.carbon_app.service.CollaborateurServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/v1/collaborateur")
@CrossOrigin
public class CollaborateurController {
    private final CollaborateurServiceImpl collaborateurService;

    public CollaborateurController(CollaborateurServiceImpl collaborateurService){
        this.collaborateurService = collaborateurService;
    }

    @GetMapping("/find/{id}")
    public Collaborateur getCollaborateur(@PathVariable Integer id){
        return collaborateurService.getCollaborateur(id);
    }

    @GetMapping("/all")
    public List<Collaborateur> getCollaborateurs(){
        return collaborateurService.getAllCollaborateurs();
    }

    @PostMapping("/add")
    public ResponseEntity<MessageResponse> addCollaborateur(@RequestBody CollaborateurDto collaborateurDto){
        MessageResponse newCollaborateur = collaborateurService.createCollaborateur(collaborateurDto);
        return new ResponseEntity<>(newCollaborateur, HttpStatus.CREATED);
    }






}
