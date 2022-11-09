package platform.codingnomads.co.springdata.lab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import platform.codingnomads.co.springdata.lab.models.DestinationUnknown;
import platform.codingnomads.co.springdata.lab_complete.models.PointOfInterest;

import java.util.List;

public interface DestinationUnknownRepository extends JpaRepository<DestinationUnknown, Long> {

    List<PointOfInterest> findAllByArea_code(String code);

    List<PointOfInterest> findAllDistinctByRoutes_codeContaining(String code);

}
