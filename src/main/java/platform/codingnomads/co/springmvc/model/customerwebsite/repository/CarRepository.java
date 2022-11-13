package platform.codingnomads.co.springmvc.model.customerwebsite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import platform.codingnomads.co.springmvc.model.customerwebsite.domain.RentalCar;

public interface CarRepository extends JpaRepository<RentalCar, Long> {

    RentalCar findByCustomerId(Long id);
}
