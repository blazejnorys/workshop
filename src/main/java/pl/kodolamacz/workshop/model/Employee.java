package pl.kodolamacz.workshop.model;

import org.springframework.stereotype.Component;

/**
 * Created by Pingwinek on 2017-07-04.
 */
@Component
public class Employee {
    private int id;
    private String EmployeeName;
    private String EmployeeSurname;


    public Employee() {
    }

    public Employee(int id, String employeeName, String employeeSurname) {
        this.id = id;
        EmployeeName = employeeName;
        EmployeeSurname = employeeSurname;

    }

    public String getEmployeeName() {
        return EmployeeName;
    }

    public void setEmployeeName(String employeeName) {
        EmployeeName = employeeName;
    }

    public String getEmployeeSurname() {
        return EmployeeSurname;
    }

    public void setEmployeeSurname(String employeeSurname) {
        EmployeeSurname = employeeSurname;
    }
}
