package oscar.carbon_app.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import oscar.carbon_app.data.models.SitePer;
import oscar.carbon_app.data.payloads.request.SitePerDto;
import oscar.carbon_app.data.payloads.response.MessageResponse;
import oscar.carbon_app.service.PerServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/api/v1/per")
@CrossOrigin
public class PerController {
    private final PerServiceImpl perService;

    public PerController(PerServiceImpl perService) {
        this.perService = perService;
    }

    @GetMapping("/all")
    public List<SitePer> getAllSitesPer(){
        return perService.getAllSitesPer();
    }

    @GetMapping("/lastEntryDate")
    public String getLastEntryDate(@RequestParam Integer id_per){
        return perService.getLastEntryDate(id_per);
    }

    @PostMapping("/add")
    public ResponseEntity<MessageResponse> addSitePer(@RequestBody SitePerDto dto){
        MessageResponse newSitePer = perService.createPerForm(dto);
        return new ResponseEntity<>(newSitePer, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<MessageResponse> updateSitePer(@RequestBody SitePerDto dto){
        MessageResponse response = perService.updateSitePer(dto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
