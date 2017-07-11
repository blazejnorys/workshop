package pl.kodolamacz.workshop.rest;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;
import pl.kodolamacz.workshop.entity.Employee;

import static org.junit.Assert.*;

/**
 * Created by Pingwinek on 2017-07-10.
 */
public class RestControllerTest {
    final String BASE_URL = "http://localhost:8080/spring";
    RestTemplate restTemplate = new RestTemplate();

//    @Test
//    public void should_add_employee(){
//        //given
//        Employee employee = new Employee(0,"fazowski","fazowki");
//        //when
//        String response = restTemplate.postForObject(BASE_URL + "/rest/save", employee, String.class);
//        //then
//        Assertions.assertThat(response).contains("fazowski");
//    }
}