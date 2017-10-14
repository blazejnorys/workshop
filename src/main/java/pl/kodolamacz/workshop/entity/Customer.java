package pl.kodolamacz.workshop.entity;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;

/**
 * Created by Pingwinek on 2017-07-04.
 */
@Component
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Pattern(regexp="[a-zA-Z]+")
    @NotEmpty
    private String CustomerName;
    @Pattern (regexp="[a-zA-Z]+")
    @NotEmpty
    private String CustomerSurname;
    @Pattern (regexp = "\\w+")
    @NotEmpty
    private String car;
//    @NotEmpty
//    @Pattern (regexp = "[0-9]+")
    private int phonenumber;

    public Customer(String customerName, String customerSurname, String car, int phonenumber) {
        CustomerName = customerName;
        CustomerSurname = customerSurname;
        this.car = car;
        this.phonenumber = phonenumber;
    }

    public Customer(int id, String customerName, String customerSurname, String car, int phonenumber) {
        this.id=id;
        CustomerName = customerName;
        CustomerSurname = customerSurname;
        this.car = car;
        this.phonenumber = phonenumber;

    }

    public Customer() {
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public String getCustomerSurname() {
        return CustomerSurname;
    }

    public void setCustomerSurname(String customerSurname) {
        CustomerSurname = customerSurname;
    }

    public int getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(int phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
