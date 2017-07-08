package pl.kodolamacz.workshop.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.kodolamacz.workshop.dao.ServiceDao;

/**
 * Created by Pingwinek on 2017-07-04.
 */
@Component
public class ServiceService {

    @Autowired
    ServiceDao serviceDao;

}

