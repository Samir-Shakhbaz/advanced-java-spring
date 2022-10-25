package platform.codingnomads.co.springdata.example.ddl.manytomany.jointableexample;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String first_name;

    @Column(nullable = false)
    private String last_name;

    @Column(nullable = false)
    private int age;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            //change join table name
            name = "user_image_join_table"
            //specify a column named location_latitude referencing the latitude column in the locations table
//            inverseJoinColumns = @JoinColumn(name = "user_image", referencedColumnName = "image")
    )
    private Set<Image> images;
}