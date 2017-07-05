package pl.kodolamacz.workshop.GUI;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pl.kodolamacz.workshop.service.JobService;

/**
 * Created by Pingwinek on 2017-07-04.
 */
public class MainApp {
    public static void main(String[] args) {


        AbstractApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");  //ctrl alt space, ctrl alt l
        applicationContext.getBean(JobService.class);

    }
}
