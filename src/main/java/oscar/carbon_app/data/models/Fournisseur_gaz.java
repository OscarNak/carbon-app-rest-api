package oscar.carbon_app.data.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity
@Data
@Table(name = "fournisseur_gaz")
public class Fournisseur_gaz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nom;

    public Fournisseur_gaz(){}
}
