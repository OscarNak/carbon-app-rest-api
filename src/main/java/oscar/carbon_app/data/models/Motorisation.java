package oscar.carbon_app.data.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "motorisation_voiture")
public class Motorisation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String motorisation;

}
