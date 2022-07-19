package oscar.carbon_app.data.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "fournisseur_elec")
public class Fournisseur_elec {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nom;

    public Fournisseur_elec(){}
}
