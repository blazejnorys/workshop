package pl.kodolamacz.workshop.service.repository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.kodolamacz.workshop.entity.Employee;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
    public Employee findEmployeeById(int Id) {
        return entityManager
                .createQuery("select e from Employee e where id=:id",Employee.class)
                .setParameter("id",Id)
                .getSingleResult();
    }

    @Override
    public Employee addEmployee(Employee employee) {
        entityManager.persist(employee);
        entityManager.flush();
        entityManager.refresh(employee);
        return employee;

    }

    @Override
    public void changeEmployeeName(int id, String name) {
        entityManager
                .createQuery("update Employee set employeeName=:name where id=:id")
                .setParameter("name",name)
                .setParameter("id",id);

    }

    @Override
    public void changeEmployeeSurname(int id, String surname) {
        entityManager
                .createQuery("update Employee set emplyeeSurname=:surname where id=:id")
                .setParameter("surname",surname)
                .setParameter("id",id);
    }
}
