package pl.kodolamacz.workshop.dao;

import pl.kodolamacz.workshop.model.Customer;

import java.util.List;

/**
 * Created by Pingwinek on 2017-07-04.
 */
public interface CustomerDao {
    List<Customer> findAllCustomer();

    List<Customer> findAllCustomerBySurname(String customerSurname);

    void addCustomer(Customer c);
}
