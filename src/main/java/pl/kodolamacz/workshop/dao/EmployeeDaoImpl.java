package pl.kodolamacz.workshop.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import pl.kodolamacz.workshop.model.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;
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
                getRowMapper());
        return employees;
    }

    @Override
    public List<Employee> findAllEmployeeBySurname(String employeeSurname) {
        List<Employee> employees = jdbcTemplate.query("SELECT * FROM employee where surname=?", getRowMapper(), employeeSurname);

        return employees;
    }

    @Override
    public void addEmployee(String name, String surname){
        jdbcTemplate.update("INSERT INTO employee(name, surname) VALUES (?,?)",name,surname);

    }

    @Override
    public void addEmployee(Employee employee) {
        String name = employee.getEmployeeName();
        String surname = employee.getEmployeeSurname();
        jdbcTemplate.update("INSERT INTO employee (name, surname) VALUES (?,?)",name,surname);

    }

    @Override
    public void editEmployee(int id, String newName) {
        jdbcTemplate.update("UPDATE INTO employee SET name=? where id=?",newName,id);

    }






    private RowMapper<Employee> getRowMapper() {
        return new RowMapper<Employee>() {
            @Override
            public Employee mapRow(ResultSet resultSet, int i) throws SQLException {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String suname = resultSet.getString("surname");

                return new Employee(id,name,suname);
            }
        };
    }


}
