package platform.codingnomads.co.springdata.example.ddl.joincolumn;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "fruit")
@NoArgsConstructor
@Getter
@Setter

public class Fruit {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "type")
    private String type;




}
