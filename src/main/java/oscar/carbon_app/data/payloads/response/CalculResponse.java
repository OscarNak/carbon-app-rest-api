package oscar.carbon_app.data.payloads.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CalculResponse {
    private double emissions_totales;
    private double emissions_totales_collab;
    private double emissions_totales_teletravail;
    private double emissions_totales_dechets;
    private double emissions_dechets_recyclables;
    private double emissions_totales_transports;
    private double emissions_voyage_affaires;
    private double emissions_voiture;
    private double emissions_bus;
    private double emissions_tramway;
}
