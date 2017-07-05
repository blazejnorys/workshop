package pl.kodolamacz.workshop.dao;

import pl.kodolamacz.workshop.model.Employee;

import java.util.List;

/**
 * Created by Pingwinek on 2017-07-04.
 */
public interface EmployeeDao {
    List<Employee> findAllEmployee();

    List<Employee> findAllEmployeeBySurname(String employeeSurname);

    void addEmployee(String name, String surname);

    void editEmployee();
}
