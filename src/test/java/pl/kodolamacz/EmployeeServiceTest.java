package pl.kodolamacz;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.kodolamacz.workshop.model.Employee;
import pl.kodolamacz.workshop.service.EmployeeService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.extractProperty;

/**
 * Created by Pingwinek on 2017-07-04.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class EmployeeServiceTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void should_add_employee() {
        //given
        String employeeName = "Karol";
        String employeeSurname = "Karolkowski";
        //when
        employeeService.addEmployee(employeeName, employeeSurname);
        //then
        int count = jdbcTemplate.queryForObject("Select count(*) from employee where name like ?",
                Integer.class, employeeName);
        Assertions.assertThat(count).isEqualTo(1);
    }

    @Test
    public void should_add_employee_as_object() {
        //given
        Employee employee = new Employee("Ziomek", "Ziomkowski");
        //when
        employeeService.addEmployee(employee);
        //then
        int count = jdbcTemplate.queryForObject("Select count(*) from employee where name like ?",
                Integer.class, employee.getEmployeeName());
        Assertions.assertThat(count).isEqualTo(1);
    }

    @Test
    public void should_find_all_employee() {
        //given
        //when
        List<Employee> actualList = employeeService.findAllEmployee();
        //then
        List<Employee> employeeList = jdbcTemplate.query("Select * from employee", getEmployeeRowMapperTest());
        System.out.println(actualList.size());
        System.out.println(employeeList.size());
        Assertions.assertThat(actualList.size()).isEqualTo(employeeList.size());
    }


    @Test
    public void should_find_employee_by_surname(){
        //given
        List<Employee> actualList = employeeService.findAllEmployeeBySurname("Mietkowski");
        String surname = "Mietkowski";
        //when
        List<Employee> employeeList = jdbcTemplate.query("Select * from employee where surname=?", getEmployeeRowMapperTest(), surname);
        //then

        Assertions.assertThat(actualList.size()).isEqualTo(employeeList.size());

    }

    @Test
    public void should_edit_employees_name(){
        //given
        String name = "Mieczysław";
        int getIdMietek = jdbcTemplate.query("Select id from employee where name =?",getEmployeeRowMapperTest(),name);
        //when
        employeeService.

    }



    // REMOVE I EDIT



    private RowMapper<Employee> getEmployeeRowMapperTest() {
        return (resultSet, i) -> {
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            String surname = resultSet.getString("surname");

            return new Employee(id, name, surname);
        };
    }
}
