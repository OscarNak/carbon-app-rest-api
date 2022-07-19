package oscar.carbon_app.data.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@Table(name = "collaborateur")
public class Collaborateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(cascade = CascadeType.ALL, targetEntity = SitePer.class)
    @JoinColumn(name = "id_per")
    private SitePer per;

    @OneToMany(targetEntity = Voiture.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "cv_fk", referencedColumnName = "id")
    List<Voiture> voitures;


    private String date_saisie;
    private Integer distance_maison_travail;
    private Integer nb_jours_teletravail_semaine;
    private Integer nb_jours_voiture_semaine;
    private Integer nb_jours_bus_semaine;
    private Integer nb_jours_tramway_semaine;
    private float conso_elec_kwh_mois;
    private float conso_gaz_kwh_mois;
    private float conso_eau_m3_mois;
    private Integer dechets_kg_semaine;
    private Integer dechets_recyclage_kg_semaine;

    public Collaborateur() {
    }

}
