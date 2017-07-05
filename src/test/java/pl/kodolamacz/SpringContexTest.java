package pl.kodolamacz;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.kodolamacz.workshop.service.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Pingwinek on 2017-07-04.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class SpringContexTest {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private JobService jobService;

    @Autowired
    private ServiceService serviceService;

    @Autowired
    private WarehouseService warehouseService;

    @Test
    public void shoulRunContext(){

        //given
        //when
        //then
        assertThat(customerService).isNotNull();
        assertThat(employeeService).isNotNull();
        assertThat(jobService).isNotNull();
        assertThat(serviceService).isNotNull();
        assertThat(warehouseService).isNotNull();

    }
}
