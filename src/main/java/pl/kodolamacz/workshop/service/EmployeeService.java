package pl.kodolamacz.workshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kodolamacz.workshop.hibernate.EmployeeDao;
import pl.kodolamacz.workshop.hibernate.model.Employee;

import java.util.List;

/**
 * Created by Pingwinek on 2017-07-04.
 */
@Service
public class EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    public List<Employee> findAllEmployee(){
        return employeeDao.findAllEmployee();
    }



    public void addEmployee(Employee employee){
        employeeDao.addEmployee(employee);
    }







}


