package oscar.carbon_app.web;

import org.springframework.web.bind.annotation.*;
import oscar.carbon_app.data.payloads.response.CalculResponse;
import oscar.carbon_app.service.CalculServiceImpl;

@RestController
@RequestMapping("/api/v1/calcul")
@CrossOrigin
public class CalculController {

    private final CalculServiceImpl calculService;

    public CalculController(CalculServiceImpl calculService) {
        this.calculService = calculService;
    }

    @PostMapping ("/bilan")
    public CalculResponse calculBilan(@RequestParam Integer per_id){
        return calculService.calculBilan(per_id);
    }
}
