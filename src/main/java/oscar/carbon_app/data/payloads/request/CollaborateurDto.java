package oscar.carbon_app.data.payloads.request;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CollaborateurDto {
    private Integer id_per;
    private Integer nb_jours_teletravail_semaine;
    private Integer distance_maison_travail;
    private Integer nb_jours_voiture_semaine;
    private Integer nb_jours_bus_semaine;
    private Integer nb_jours_tramway_semaine;
    private float conso_elec_kwh_mois;
    private float conso_gaz_kwh_mois;
    private float conso_eau_m3_mois;
    private Integer dechets_kg_semaine;
    private Integer dechets_recyclage_kg_semaine;

    private List<VoitureDto> voitures;
}
