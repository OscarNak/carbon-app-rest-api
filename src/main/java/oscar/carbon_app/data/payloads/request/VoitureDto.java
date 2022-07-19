package oscar.carbon_app.data.payloads.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class VoitureDto {

    private Integer id_motorisation;
    private Integer id_type;
    private Integer age;

}
