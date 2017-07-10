package pl.kodolamacz.workshop.entity;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.validation.constraints.Pattern;

/**
 * Created by Pingwinek on 2017-07-04.
 */
@Component
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Pattern (regexp="[a-zA-Z]+")
    @NotEmpty
    private String employeeName;
    @Pattern (regexp="[a-zA-Z]+")
    @NotEmpty
    private String employeeSurname;


    public Employee() {
    }

    public Employee(int id, String employeeName, String employeeSurname) {
        this.id = id;
        this.employeeName = employeeName;
        this.employeeSurname = employeeSurname;

    }

    public Employee(String employeeName, String employeeSurname) {
        this.employeeName = employeeName;
        this.employeeSurname = employeeSurname;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeSurname() {
        return employeeSurname;
    }

    public void setEmployeeSurname(String employeeSurname) {
        this.employeeSurname = employeeSurname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
