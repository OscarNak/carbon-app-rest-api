package oscar.carbon_app.data.payloads.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class SitePerDto {

    private Integer id_per;
    private Integer id_fournisseur_gaz;
    private Integer id_fournisseur_elec;
    private float conso_elec_kwh_mois;
    private float conso_gaz_kwh_mois;
    private float conso_eau_m3_mois;
    private Integer dechets_kg_semaine;
    private Integer dechets_recyclage_kg_semaine;
    private Integer conso_papier_kilo_semaine;
    private Integer nb_collabs;

}
