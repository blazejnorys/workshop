package pl.kodolamacz.workshop.entity;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.ManyToAny;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.List;

/**
 * Created by Pingwinek on 2017-10-13.
 */
@Component
@Entity
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty
    @Pattern(regexp="[a-zA-Z]+")
    private String jobName;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Employee> employeeList;


    @LazyCollection(LazyCollectionOption.FALSE)
    @ManyToMany
    private List<Customer> customerList;

    public Job() {
    }

    public Job(String jobName, List<Employee> employeeList, List<Customer> customerList) {
        this.jobName = jobName;
        this.employeeList = employeeList;
        this.customerList = customerList;
    }



    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }
}
