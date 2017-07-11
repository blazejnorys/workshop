package pl.kodolamacz.workshop.service;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.kodolamacz.workshop.entity.Customer;


import java.util.List;



/**
 * Created by Pingwinek on 2017-07-04.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class CustomerServiceTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private CustomerService customerService;

    @Test
    public void should_list_all_customers() {
        //given
        //when
        List<Customer> customerList = customerService.findAllCustomer();
        //then
        Assertions.assertThat(customerList.size()).isGreaterThan(3);
    }

    @Test
    public void should_list_customer_by_id() {
        //given
        //when
        Customer customerById = customerService.findCustomerById(3);
        //then
        Assertions.assertThat(customerById.getCustomerName()).isNotNull();
        Assertions.assertThat(customerById.getCustomerName()).isNotEmpty();

    }

    @Test
    public void should_add_customer() {
        //given
        Customer customer = new Customer(0, "Pusia", "Pusiowska", "Mazda", 100200300);
        //when
        customerService.addCustomer(customer);
        //then
        Customer customerById = customerService.findCustomerById(customer.getId());

        Assertions.assertThat(customerById.getCustomerName()).isEqualTo("Pusia");
    }

    @Test
    public void should_change_customer_details() {
        //given
        //when
        customerService.editCustomerDetails(1, "NewName", "NewSurname", "Toyota", 200300400);
        Customer customerEdited = customerService.findCustomerById(1);
        //then
        Assertions.assertThat(customerEdited.getCustomerName()).contains("NewName");
    }

    @Test
    public void should_remove_customer_by_id() {
        //given
        Customer customerNew = new Customer(0, "ToRemoveName", "ToRemoveSurname", "Nissan", 400500600);
        customerService.addCustomer(customerNew);
        Customer customerById = customerService.findCustomerById(customerNew.getId());

        //when
        customerService.removeCustomer(customerById.getId());
        List<Customer> customerList = customerService.findAllCustomer();
        //then

        Assertions.assertThat(customerList).doesNotContain(customerById);
    }
}




