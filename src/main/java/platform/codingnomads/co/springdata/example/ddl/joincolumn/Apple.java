package platform.codingnomads.co.springdata.example.ddl.joincolumn;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "apples")
@NoArgsConstructor
@Getter
@Setter

public class Apple {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.LAZY)
    //use @JoinColumns to indicate multiple join columns are needed in the examples table
    @JoinColumns({
            //define the first join column. It will be called referenced_id and references the id column in the user table
            @JoinColumn(name = "references_id", referencedColumnName = "id"),
            //define the second join column. It will be called references_name and references the name column in the user table
            @JoinColumn(name = "references_type", referencedColumnName = "type")
    })
    private Fruit fruit;

}
