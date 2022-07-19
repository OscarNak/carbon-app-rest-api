package oscar.carbon_app.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import oscar.carbon_app.data.models.SitePer;

@Repository
public interface PerRepository extends JpaRepository<SitePer, Integer> {

}
