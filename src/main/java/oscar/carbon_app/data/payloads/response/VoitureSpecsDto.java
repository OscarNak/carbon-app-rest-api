package oscar.carbon_app.data.payloads.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import oscar.carbon_app.data.models.Motorisation;
import oscar.carbon_app.data.models.Type;
import oscar.carbon_app.data.models.Voiture;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class VoitureSpecsDto {
    private List<Motorisation> motorisations;
    private List<Type> types;
}
