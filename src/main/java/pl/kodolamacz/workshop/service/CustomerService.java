package pl.kodolamacz.workshop.service;

import com.sun.xml.internal.ws.developer.UsesJAXBContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pl.kodolamacz.workshop.dao.CustomerDao;
import pl.kodolamacz.workshop.model.Customer;

/**
 * Created by Pingwinek on 2017-07-04.
 */
@Component
public class CustomerService {

    @Autowired
    CustomerDao customerDao;
}



