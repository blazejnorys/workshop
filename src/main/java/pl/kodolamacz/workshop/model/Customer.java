package pl.kodolamacz.workshop.model;

import org.springframework.stereotype.Component;

/**
 * Created by Pingwinek on 2017-07-04.
 */
@Component
public class Customer {

    private String CustomerName;
    private String CustomerSurname;
    private int phoneNumber;

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

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
