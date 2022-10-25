package platform.codingnomads.co.springdata.example.ddl.onetoone.unidirectional;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "wheels")
@NoArgsConstructor
@Getter
@Setter
public class Wheel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String brand;

    @Column(name = "radius")
    private double radius;

    @OneToOne(mappedBy = "wheel")
    private Car car;
}
