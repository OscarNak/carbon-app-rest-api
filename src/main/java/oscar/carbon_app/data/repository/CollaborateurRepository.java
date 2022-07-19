package oscar.carbon_app.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import oscar.carbon_app.data.models.Collaborateur;

import java.util.List;

@Repository
public interface CollaborateurRepository  extends JpaRepository<Collaborateur,Integer> {
    @Query(
            value = "SELECT * FROM collaborateur u WHERE id_per = ?1",
            nativeQuery = true
    )
    List<Collaborateur> findCollaborateursByPerID(Integer PerID);
}
