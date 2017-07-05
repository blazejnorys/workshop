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
    public void should_add_employee(){
        //given
        String employeeName = "Karol";
        String employeeSurname = "Karolkowski";

        //when
        employeeService.addEmployee(employeeName,employeeSurname);

        //then
        int count = jdbcTemplate.queryForObject("Select count(*) from employee where name like ?",
                Integer.class, employeeName);
        Assertions.assertThat(count).isEqualTo(1);
    }

    @Test
    public void should_find_employee(){
        //given
        //when
        List<Employee> listactual = employeeService.findAllEmployee();
        //then
        List<Employee> listEmployee = jdbcTemplate.query("Select * from employee", new RowMapper<Employee>() {
            @Override
            public Employee mapRow(ResultSet resultSet, int i) throws SQLException {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");

                return new Employee(id, name, surname);
            }
        });
        System.out.println(listactual.size());
        System.out.println(listEmployee.size());
        Assertions.assertThat(listactual.size()).isEqualTo(listEmployee.size());


    }






//    @Test
//    public void shouldReturnAllWorkers(){
//        //given
//        employeeService.addEmployee(employee1);
//        employeeService.addEmployee(employee2);
//        //when
//        List<Employee> actualList=employeeService.findAllEmployee();
//        //then
//        assertThat(actualList).isNotNull();
//        assertThat(actualList.size()).isEqualTo(expectedList.size());
//
//
//
//    }
//
//    @Test
//    public void shouldAddNewWorker(){
//        //given
//        employeeService.addEmployee(employee1);
//        //when
//        List<Employee> actualList = employeeService.findAllEmployee();
//        //then
//        assertThat(actualList).isNotNull();
//        assertThat(actualList.size()).isEqualTo(1);
//
//    }
//
//    @Test
//    public void shouldFindWorkerBySurname(){
//        //given
//        employeeService.addEmployee(employee1);
//        //employeeService.addEmployee(employee2);
//        //when
//        List<Employee> actualList = employeeService.findAllEmployeeBySurname("Mietkowski");
//        //then
//        assertThat(actualList.get(0).getEmployeeSurname()).isEqualTo("Mietkowski");
//
//
//    }
//
//    @Test
//    public void shouldEditWorker(){
//
//    }
}
