package pl.kodolamacz.workshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.kodolamacz.workshop.dao.WarehouseDao;

/**
 * Created by Pingwinek on 2017-07-04.
 */
@Component
public class WarehouseService {

    @Autowired
    WarehouseDao warehouseDao;


}
