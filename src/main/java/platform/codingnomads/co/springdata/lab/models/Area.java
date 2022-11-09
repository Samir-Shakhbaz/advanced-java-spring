package platform.codingnomads.co.springdata.lab.models;

import lombok.*;
import platform.codingnomads.co.springdata.lab_complete.models.PointOfInterest;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "areas")
@Builder
@ToString
public class Area implements Serializable {

    private static final long serialVersionUID = 153236560504273881L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String code;

    @OneToMany(mappedBy = "area")
    private List<DestinationUnknown> destinationUnknown;

    public void addDestinationUnknown(DestinationUnknown destinationUnknown) {

            if (this.destinationUnknown == null) {
                this.destinationUnknown = new ArrayList<>(Collections.singletonList(destinationUnknown));
            } else {
                this.destinationUnknown.add(destinationUnknown);
            }
        }
    }

