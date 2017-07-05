package pl.kodolamacz.workshop.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Pingwinek on 2017-07-04.
 */
@Component
public class Job {

    @Autowired
    private Employee employee;
    @Autowired
    private Customer customer;
    @Autowired
    private Part part;
    @Autowired
    private Service service;

}
