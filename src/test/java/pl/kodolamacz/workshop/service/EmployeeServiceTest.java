package pl.kodolamacz.workshop.service;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.kodolamacz.workshop.entity.Employee;
import pl.kodolamacz.workshop.service.EmployeeService;

import javax.persistence.EntityManager;

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

    @Test
    public void should_list_all_employees(){
        //given
        //when
        List<Employee> employeeList = employeeService.findAllEmployee();
        //then
        Assertions.assertThat(employeeList.size()).isGreaterThan(3);
    }

    @Test
    public void should_list_employee_by_id(){
        //given
        //when
        Employee employeeById = employeeService.findEmployeeById(3);
        //then
        Assertions.assertThat(employeeById.getEmployeeName()).isNotNull();
        Assertions.assertThat(employeeById.getEmployeeName()).isNotEmpty();

    }

    @Test
    public void should_add_employee() {
        //given
        Employee employee = new Employee(0,"Pusia","Pusiowska");
        //when
        employeeService.addEmployee(employee);
        //then
        Employee employeeById=employeeService.findEmployeeById(employee.getId());

        Assertions.assertThat(employeeById.getEmployeeName()).isEqualTo("Pusia");
    }
    @Test
    public void should_change_employee_details(){
        //given
        //when
        employeeService.editEmployeeDetails(1,"NewName","NewSurname");
        Employee employeeEdited= employeeService.findEmployeeById(1);
        //then
        Assertions.assertThat(employeeEdited.getEmployeeName()).contains("NewName");
    }

    @Test
    public void should_remove_employee_by_id(){
        //given
        Employee employeeNew= new Employee(0,"ToRemoveName","ToRemoveSurname");
        employeeService.addEmployee(employeeNew);
        Employee employeeById = employeeService.findEmployeeById(employeeNew.getId());

        //when
        employeeService.removeEmployee(employeeById.getId());
        List<Employee> employeeList=employeeService.findAllEmployee();
        //then

        Assertions.assertThat(employeeList).doesNotContain(employeeById);
    }














//    //TEST REST
//    @Test
//    public void should_add_employee_as_object() {
//        //given
//        Employee employee = new Employee("Ziomek", "Ziomkowski");
//        //when
//        employeeService.addEmployee(employee);
//        //then
//        int count = jdbcTemplate.queryForObject("Select count(*) from employee where name like ?",
//                Integer.class, employee.getEmployeeName());
//        Assertions.assertThat(count).isEqualTo(1);
//    }


}
