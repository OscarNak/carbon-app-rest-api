package oscar.carbon_app.data.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "site_per")
public class SitePer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL, targetEntity = Fournisseur_elec.class)
    @JoinColumn(name = "id_elec")
    private Fournisseur_elec fElec;

    @ManyToOne(cascade = CascadeType.ALL, targetEntity = Fournisseur_gaz.class)
    @JoinColumn(name = "id_gaz")
    private Fournisseur_gaz fGaz;

    private String nom;
    private String date_saisie;
    private String localisation;
    private Float conso_elec_kwh_mois;
    private Float conso_gaz_kwh_mois ;
    private Float conso_eau_m3_mois;
    private Integer dechets_kg_semaine;
    private Integer dechets_recyclage_kg_semaine;
    private Integer conso_papier_kilo_semaine;
    private Integer nb_collabs;

    public SitePer(){}

}
