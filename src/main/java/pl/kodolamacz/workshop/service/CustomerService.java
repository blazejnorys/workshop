package pl.kodolamacz.workshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.kodolamacz.workshop.dao.CustomerDao;

/**
 * Created by Pingwinek on 2017-07-04.
 */
@Component
public class CustomerService {

    @Autowired
    CustomerDao customerDao;
}



