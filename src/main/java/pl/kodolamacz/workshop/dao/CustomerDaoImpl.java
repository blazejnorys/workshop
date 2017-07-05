package pl.kodolamacz.workshop.dao;

import org.springframework.stereotype.Repository;
import pl.kodolamacz.workshop.model.Customer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pingwinek on 2017-07-04.
 */
@Repository
public class CustomerDaoImpl implements CustomerDao {

    List<Customer> customerList = new ArrayList<Customer>();

    @Override
    public List<Customer> findAllCustomer(){
        return customerList;
    }

    @Override
    public List<Customer> findAllCustomerBySurname(String customerSurname){
        List<Customer> foundEmployee = new ArrayList<Customer>();
        for (Customer c : customerList) {
            if (c.getCustomerSurname().equals(customerSurname)){
                foundEmployee.add(c);
            }

        }
        return foundEmployee;
    }

    @Override
    public void addCustomer(Customer c){
        customerList.add(c);

    }
}
