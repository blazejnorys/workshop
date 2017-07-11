package pl.kodolamacz.workshop.service.repository;

import pl.kodolamacz.workshop.entity.Customer;
import pl.kodolamacz.workshop.entity.Employee;

import java.util.List;

/**
 * Created by Pingwinek on 2017-07-04.
 */
public interface CustomerDao {
    List<Customer> findAllCustomer();

    Customer findCustomerById(int id);

    Customer addCustomer(Customer c);

    void changeCustomerDetails(int id, String name,String surname,String car,int phonenumber);

    void removeCustomer(int id);
}
