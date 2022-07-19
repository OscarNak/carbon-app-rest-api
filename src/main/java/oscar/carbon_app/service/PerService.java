package oscar.carbon_app.service;

import org.springframework.stereotype.Component;
import oscar.carbon_app.data.models.SitePer;
import java.util.List;

@Component
public interface PerService {
    List<SitePer> getAllSitesPer();
}
