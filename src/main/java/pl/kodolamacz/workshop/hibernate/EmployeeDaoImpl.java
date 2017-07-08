package pl.kodolamacz.workshop.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.kodolamacz.workshop.entity.Employee;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

/**
 * Created by Pingwinek on 2017-07-04.
 */

public class EmployeeDaoImpl implements EmployeeDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Employee> findAllEmployee() {
        return entityManager
                .createQuery("select e from Employee e", Employee.class)
                .getResultList();
    }


    @Override
    public Employee addEmployee(Employee employee) {
        entityManager.persist(employee);
        entityManager.flush();
        entityManager.refresh(employee);
        return employee;

    }

}
