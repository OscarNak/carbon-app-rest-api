package oscar.carbon_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import oscar.carbon_app.data.models.Voiture;
import oscar.carbon_app.data.payloads.response.VoitureSpecsDto;
import oscar.carbon_app.data.repository.MotorisationRepository;
import oscar.carbon_app.data.repository.TypeRepository;
import oscar.carbon_app.data.repository.VoitureRepository;

@Service
public class VoitureServiceImpl {

    @Autowired
    MotorisationRepository repoMoto;

    @Autowired
    TypeRepository repoType;

    public VoitureSpecsDto getSpecs(){
        VoitureSpecsDto dto = new VoitureSpecsDto();
        dto.setMotorisations(repoMoto.findAll());
        dto.setTypes(repoType.findAll());
        return dto;
    }

}
