package pl.kodolamacz.workshop.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.kodolamacz.workshop.entity.Employee;
import pl.kodolamacz.workshop.service.EmployeeService;

import java.util.List;

/**
 * Created by Pingwinek on 2017-07-10.
 */
@org.springframework.web.bind.annotation.RestController   //autoamtyczne response body
@RequestMapping(value="/rest")
public class RestController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value="/save", method = RequestMethod.POST)
    public String saveEmployee(@RequestBody Employee employee){
        employeeService.addEmployee(employee);
        return "Zapisano typa"+employee.getEmployeeName()+" "+employee.getEmployeeSurname();
    }

    @RequestMapping(value = "/list")
    public List<Employee> listEmployee() {
        return employeeService.findAllEmployee();

    }
}
