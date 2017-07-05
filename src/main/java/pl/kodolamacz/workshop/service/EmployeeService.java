package pl.kodolamacz.workshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.kodolamacz.workshop.dao.EmployeeDao;
import pl.kodolamacz.workshop.model.Employee;

import java.util.List;

/**
 * Created by Pingwinek on 2017-07-04.
 */
@Component
public class EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    public List<Employee> findAllEmployee(){
        return employeeDao.findAllEmployee();
    }

    public void addEmployee(String name, String surname){
        employeeDao.addEmployee(name,surname);
    }

    public void addEmployee(Employee employee){
        employeeDao.addEmployee(employee);
    }

    public List<Employee> findAllEmployeeBySurname(String employeeSurname){
        return employeeDao.findAllEmployeeBySurname(employeeSurname);
    }

    public void editEmployeesName(int id, String newName){

    }



}


