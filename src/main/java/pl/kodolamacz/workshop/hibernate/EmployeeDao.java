package pl.kodolamacz.workshop.hibernate;

import pl.kodolamacz.workshop.hibernate.model.Employee;

import java.util.List;

/**
 * Created by Pingwinek on 2017-07-04.
 */
public interface EmployeeDao {
    List<Employee> findAllEmployee();

   // List<Employee> findAllEmployeeBySurname(String employeeSurname);

    //void addEmployee(String name, String surname);

    void addEmployee(Employee employee);

    //void editEmployee(int id,String surname);
}
