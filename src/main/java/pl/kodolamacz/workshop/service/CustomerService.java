package pl.kodolamacz.workshop.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.kodolamacz.workshop.entity.Customer;
import pl.kodolamacz.workshop.dao.CustomerDao;

import java.util.List;

/**
 * Created by Pingwinek on 2017-07-04.
 */
@Service
@Transactional
public class CustomerService {

    private CustomerDao customerDao;

    public List<Customer> findAllCustomer(){
        return customerDao.findAllCustomer();
    }

    public Customer findCustomerById(int id){return customerDao.findCustomerById(id);}

    public void addCustomer(Customer customer){
        customerDao.addCustomer(customer);
    }

    public void editCustomerDetails(int id, String name, String surname, String car, int phonenumber){
        customerDao.changeCustomerDetails(id,name,surname,car,phonenumber);
    }

    public void removeCustomer(int id){
        customerDao.removeCustomer(id);
    }






    public CustomerService(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

}




