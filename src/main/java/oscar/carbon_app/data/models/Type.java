package oscar.carbon_app.data.models;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "type_voiture")
public class Type {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String type;
}
