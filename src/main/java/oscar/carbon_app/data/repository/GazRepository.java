package oscar.carbon_app.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import oscar.carbon_app.data.models.Fournisseur_gaz;

@Repository
public interface GazRepository extends JpaRepository<Fournisseur_gaz, Integer> {
}
