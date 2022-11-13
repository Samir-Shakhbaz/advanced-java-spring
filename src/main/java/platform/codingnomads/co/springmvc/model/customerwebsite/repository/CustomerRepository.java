package platform.codingnomads.co.springmvc.model.customerwebsite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import platform.codingnomads.co.springmvc.model.customerwebsite.domain.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
