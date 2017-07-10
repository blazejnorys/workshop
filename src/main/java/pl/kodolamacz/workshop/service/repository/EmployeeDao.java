package pl.kodolamacz.workshop.service.repository;

import pl.kodolamacz.workshop.entity.Employee;

import java.util.List;

/**
 * Created by Pingwinek on 2017-07-04.
 */
public interface EmployeeDao {
    List<Employee> findAllEmployee();

    Employee findEmployeeById(int Id);

    Employee addEmployee(Employee employee);

    void changeEmployeeDetails(int id, String name,String surname);

    void removeEmployee(int id);


}
