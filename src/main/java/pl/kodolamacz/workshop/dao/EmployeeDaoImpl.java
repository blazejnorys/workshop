package pl.kodolamacz.workshop.dao;

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
                .createQuery("select e from Employee e order by e.id", Employee.class)
                .getResultList();
    }

    @Override
    public Employee findEmployeeById(int id) {
        return entityManager
                .createQuery("select e from Employee e where id=:id",Employee.class)
                .setParameter("id",id)
                .getSingleResult();
    }

    @Override
    public Employee findEmployeeBySurname(String surname){
        return entityManager.createQuery("select e from Employee e where employeesurname=:surname",Employee.class)
                .setParameter("surname",surname)
                .getSingleResult();
    }

    @Override
    public List<Employee> findEmployeeBySurnameList(String surname) {
        return entityManager.createQuery("select e from Employee e where employeesurname=:surname",Employee.class)
                .setParameter("surname",surname)
                .getResultList();
    }

    @Override
    public Employee addEmployee(Employee employee) {
        entityManager.persist(employee);
        entityManager.flush();
        entityManager.refresh(employee);
        return employee;

    }

    @Override
    public void changeEmployeeDetails(int id, String name, String surname) {
        Employee employeeById = findEmployeeById(id);
        employeeById.setEmployeeName(name);
        employeeById.setEmployeeSurname(surname);
        entityManager
                .persist(employeeById);

    }

    @Override
    public void removeEmployee(int id) {
        Employee employeeById=findEmployeeById(id);
        entityManager
                .remove(employeeById);

    }

}
