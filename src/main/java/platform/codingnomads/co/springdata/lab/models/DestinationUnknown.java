package platform.codingnomads.co.springdata.lab.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import platform.codingnomads.co.springdata.lab.models.Area;
import platform.codingnomads.co.springdata.lab.models.Route;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "destination_unknown")
public class DestinationUnknown implements Serializable {

    private static final long serialVersionUID = -5832297257746489251L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "destination_generator")
    private Long id;

    private String type;
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    private platform.codingnomads.co.springdata.lab.models.Area area;

    @ManyToMany
    @JoinTable(name="dest_route", joinColumns = @JoinColumn(name = "dest_id"),
            inverseJoinColumns = @JoinColumn(name = "route_id"))
    private List<platform.codingnomads.co.springdata.lab.models.Route> routes;

    public DestinationUnknown(String type, String name, Area area) {
        this.type = type;
        this.name = name;
        this.area = area;
        area.addDestinationUnknown(this);
    }

    public DestinationUnknown(String type, String name, Route route) {
        this.type = type;
        this.name = name;
        this.routes = List.of(route);
    }

    public void addRoutes(List<Route> routes) {
        if (routes != null) {
            routes.forEach(r -> r.addDestinationUnknown(this));
        } else {
            routes = new ArrayList<>();
        }
        if (this.routes == null) {
            this.routes = routes;
        } else {
            this.routes.addAll(routes);
        }
    }

    // exclude area and routes to avoid circular reference
    @Override
    public String toString() {
        return "PointOfInterest{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

}
