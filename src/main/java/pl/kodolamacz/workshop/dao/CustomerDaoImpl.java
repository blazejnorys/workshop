package pl.kodolamacz.workshop.dao;

import org.springframework.stereotype.Repository;
import pl.kodolamacz.workshop.entity.Customer;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Pingwinek on 2017-07-04.
 */
@Repository
public class CustomerDaoImpl implements CustomerDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Customer> findAllCustomer() {
        return entityManager
                .createQuery("select c from Customer c order by c.id", Customer.class)
                .getResultList();
    }

    @Override
    public Customer findCustomerById(int id) {
        return entityManager
                .find(Customer.class, id);


    }

    @Override
    public Customer addCustomer(Customer c) {
        entityManager.persist(c);
        entityManager.flush();
        entityManager.refresh(c);
        return c;

    }

    @Override
    public void changeCustomerDetails(int id, String name, String surname, String car, int phonenumber) {
        Customer customerById = findCustomerById(id);
        customerById.setCustomerName(name);
        customerById.setCustomerSurname(surname);
        customerById.setCar(car);
        customerById.setPhonenumber(phonenumber);
        entityManager
                .persist(customerById);
    }

    @Override
    public void removeCustomer(int id) {
        Customer customerById = findCustomerById(id);
        entityManager
                .remove(customerById);

    }
}
