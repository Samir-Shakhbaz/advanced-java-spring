package platform.codingnomads.co.springmvc.model.customerwebsite.service;

import platform.codingnomads.co.springmvc.model.customerwebsite.domain.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> getAllCustomers();

    Customer saveCustomer(Customer customer);

    Customer getCustomer(Long id);

    void deleteCustomer(Long id);

    List<Customer> saveAllCustomer(List<Customer> customerList);
}
