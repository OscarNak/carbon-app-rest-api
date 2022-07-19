package oscar.carbon_app.web;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import oscar.carbon_app.data.payloads.response.VoitureSpecsDto;
import oscar.carbon_app.service.VoitureServiceImpl;

@RestController
@RequestMapping("/api/v1/voiture")
@CrossOrigin
public class VoitureController {
    private final VoitureServiceImpl voitureService;

    public VoitureController(VoitureServiceImpl voitureService) {
        this.voitureService = voitureService;
    }

    @GetMapping("/specs")
    public VoitureSpecsDto getSpecs(){
        return voitureService.getSpecs();
    }
}
