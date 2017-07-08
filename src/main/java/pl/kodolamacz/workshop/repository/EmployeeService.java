package pl.kodolamacz.workshop.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.kodolamacz.workshop.hibernate.EmployeeDao;
import pl.kodolamacz.workshop.entity.Employee;
import pl.kodolamacz.workshop.hibernate.EmployeeDaoImpl;

import javax.validation.Constraint;
import java.util.List;

/**
 * Created by Pingwinek on 2017-07-04.
 */

public class EmployeeService {


    private EmployeeDao employeeDao;

    public List<Employee> findAllEmployee(){
        return employeeDao.findAllEmployee();
    }

    public void addEmployee(Employee employee){
        employeeDao.addEmployee(employee);
    }

    public EmployeeService(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }
}


