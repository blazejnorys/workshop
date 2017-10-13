package pl.kodolamacz.workshop.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.kodolamacz.workshop.entity.Employee;
import pl.kodolamacz.workshop.dao.EmployeeDao;

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

    public void editEmployeeDetails(int id, String name, String surname){
        employeeDao.changeEmployeeDetails(id,name,surname);
    }

    public void removeEmployee(int id){
        employeeDao.removeEmployee(id);
    }

    public Employee findEmployeeBySurname(String surname){return employeeDao.findEmployeeBySurname(surname);}

    public List<Employee> findEmployeeBySurnameList (String surname){return employeeDao.findEmployeeBySurnameList(surname);}






    public EmployeeService(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

}


