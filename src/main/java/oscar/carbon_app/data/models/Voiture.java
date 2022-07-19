package oscar.carbon_app.data.models;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "voiture")
public class Voiture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer age_voiture;
    @OneToOne
    private Motorisation motorisation;
    @OneToOne
    private Type type;
    public Voiture(){}

}

