package pl.kodolamacz.workshop.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.kodolamacz.workshop.dao.*;
import pl.kodolamacz.workshop.hibernate.EmployeeDao;

/**
 * Created by Pingwinek on 2017-07-04.
 */
@Component
public class JobService {

    @Autowired
    JobDao jobDao;

    @Autowired
    CustomerDao customerDao;

    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    PartDao partDao;

    @Autowired
    ServiceDao serviceDao;

    @Autowired
    WarehouseDao warehouseDao;
}
