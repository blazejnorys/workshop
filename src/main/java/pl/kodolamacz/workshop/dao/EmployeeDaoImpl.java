package pl.kodolamacz.workshop.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.kodolamacz.workshop.model.Employee;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pingwinek on 2017-07-04.
 */
@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Employee> findAllEmployee(){
        List<Employee> employees = jdbcTemplate.query("SELECT * FROM employee",
                (resultSet,i) ->{
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String surname = resultSet.getString("surname");

                    return new Employee(id, name, surname);

                });
        return employees;
    }

    @Override
    public List<Employee> findAllEmployeeBySurname(String employeeSurname) {
        return null;
    }




//    @Override
//    public List<Employee> findAllEmployeeBySurname(String employeeSurname){
//        List<Employee> foundEmployee = new ArrayList<Employee>();
//        for (Employee employee : employeeList) {
//            if (employee.getEmployeeSurname().equals(employeeSurname)){
//                foundEmployee.add(employee);
//            }
//
//        }
//        return foundEmployee;
//    }

    @Override
    public void addEmployee(String name, String surname){
        jdbcTemplate.update("INSERT INTO employee(name, surname) VALUES (?,?)",name,surname);

    }

    @Override
    public void editEmployee() {

    }
}
