package pl.kodolamacz.workshop.GUI;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import pl.kodolamacz.workshop.entity.Customer;
import pl.kodolamacz.workshop.entity.Employee;
import pl.kodolamacz.workshop.entity.Job;
import pl.kodolamacz.workshop.service.EmployeeService;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pingwinek on 2017-07-04.
 */
public class MainApp {
    public static void main(String[] args) {


        try (ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml")) {

            EntityManagerFactory entityManagerFactory = applicationContext.getBean(EntityManagerFactory.class);
            EntityManager entityManager = entityManagerFactory.createEntityManager();
            System.out.println("########################################3");

            Employee employee1 = new Employee("EmployeeOne","EmployeeOne");
            Employee employee2 = new Employee("EmployeeTwo","EmployeeTwo");

            Customer customer1 = new Customer("CustomerOne","CustomerOne","CustomerOne",123);
            Customer customer2 = new Customer("CustomerTwo","CustomerTwo","CustomerTwo",123);
            List<Employee> employeeList = new ArrayList<>();
            List<Customer> customersList = new ArrayList<>();
            employeeList.add(employee1);
            employeeList.add(employee2);
            customersList.add(customer1);
            customersList.add(customer2);
            Job job = new Job();
            job.setJobName("JobTestowy");
            job.setCustomerList(customersList);
            job.setEmployeeList(employeeList);


            entityManager.getTransaction().begin();
            entityManager.persist(employee1);
            entityManager.persist(employee2);
            entityManager.persist(customer1);
            entityManager.persist(customer2);
            entityManager.persist(job);
            entityManager.getTransaction().commit();

            entityManager.close();



            EmployeeService employeeService = applicationContext.getBean(EmployeeService.class);

            List<Employee> employees = employeeService.findAllEmployee();

            for (Employee employee : employees) {
                System.out.println(employee.getEmployeeName());
            }

        }
    }
}
