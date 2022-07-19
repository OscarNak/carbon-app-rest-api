package oscar.carbon_app.service;

import org.springframework.stereotype.Component;
import oscar.carbon_app.data.models.Collaborateur;
import oscar.carbon_app.data.payloads.request.CollaborateurDto;
import oscar.carbon_app.data.payloads.response.MessageResponse;

import java.util.List;

@Component
public interface CollaborateurService {
    MessageResponse createCollaborateur(CollaborateurDto collaborateurDto);
    Collaborateur getCollaborateur(Integer collaborateurId);
    List<Collaborateur> getAllCollaborateurs();
    List<Collaborateur> getAllCollaborateursByPerID(Integer per_id);
}
