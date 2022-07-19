package oscar.carbon_app.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import oscar.carbon_app.data.models.Fournisseur_elec;

@Repository
public interface ElecRepository extends JpaRepository<Fournisseur_elec, Integer> {
}
