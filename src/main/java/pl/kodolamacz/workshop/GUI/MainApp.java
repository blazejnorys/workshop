package pl.kodolamacz.workshop.GUI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pl.kodolamacz.workshop.hibernate.model.Employee;
import pl.kodolamacz.workshop.service.EmployeeService;

import java.util.List;

/**
 * Created by Pingwinek on 2017-07-04.
 */
public class MainApp {
    public static void main(String[] args) {


        AbstractApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");

        EmployeeService employeeService = applicationContext.getBean(EmployeeService.class);
        List<Employee> employees = employeeService.findAllEmployee();

        for (Employee employee : employees) {
            System.out.println(employee.getEmployeeName());

        }

    }
}
