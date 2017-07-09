package pl.kodolamacz.workshop.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.kodolamacz.workshop.entity.Employee;
import pl.kodolamacz.workshop.service.repository.EmployeeDao;

import java.util.List;

/**
 * Created by Pingwinek on 2017-07-04.
 */
@Service
@Transactional
public class EmployeeService {


    private EmployeeDao employeeDao;

    public List<Employee> findAllEmployee(){
        return employeeDao.findAllEmployee();
    }

    public Employee findEmployeeById(int id){return employeeDao.findEmployeeById(id);}

    public void addEmployee(Employee employee){
        employeeDao.addEmployee(employee);
    }

    public void editEmployeeName(int id, String name){
        employeeDao.changeEmployeeName(id,name);
    }

    public void editEmployeeSurname(int id, String surname){
        employeeDao.changeEmployeeSurname(id,surname);
    }





    public EmployeeService(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

}


