package pl.kodolamacz.workshop.dao;

import org.springframework.stereotype.Repository;
import pl.kodolamacz.workshop.model.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pingwinek on 2017-07-04.
 */
@Repository
public class ServiceDaoImpl implements ServiceDao {

    List<Service> services = new ArrayList<Service>();
}
