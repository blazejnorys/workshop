package pl.kodolamacz.workshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.kodolamacz.workshop.entity.Employee;
import pl.kodolamacz.workshop.service.EmployeeService;

import javax.validation.Valid;
import java.util.List;

@Controller
public class EmployeeController {


    private EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //EMPLOYEE INDEX
    @RequestMapping("employee-index.html")
    public ModelAndView getEmployeeIndex() {
        ModelAndView modelAndView = new ModelAndView("employeeViews/employeeIndex");
        return modelAndView;
    }
    //SHOW EMPLOYEES
    @RequestMapping("show-employees.html")
    public ModelAndView getAllEmployee() {
        ModelAndView modelAndView = new ModelAndView("employeeViews/employees");
        modelAndView.addObject("employees", employeeService.findAllEmployee());
        return modelAndView;
    }

    //ADD EMPLOYEE GET METHOD
    @RequestMapping(value = "add-employee.html", method = RequestMethod.GET)
    public ModelAndView showAddEmployeeForm() {

        return new ModelAndView("employeeViews/addEmployee","employee", new Employee());

    }
    //ADD EMPLOYEE POST METHOD
    @RequestMapping(value = "add-employee.html", method = RequestMethod.POST)
    public ModelAndView addEmployee(@Valid @ModelAttribute Employee employee, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("employeeViews/addEmployee");
        }
        employeeService.addEmployee(employee);
        return new ModelAndView("employeeViews/addEmployeeConfirmation", "employee", employee);
    }

    //EDIT EMPLOYEE GET METHOD
    @RequestMapping (value ="edit-employee.html", method = RequestMethod.GET)
    public ModelAndView showEditEmployee(@RequestParam(name="id")Integer id){
        ModelAndView modelAndView = new ModelAndView("employeeViews/editEmployee");
        modelAndView.addObject(employeeService.findEmployeeById(id));
        return modelAndView;
    }

    //EDIT EMPLOYEE POST METHOD
    @RequestMapping (value="edit-employee.html", method =RequestMethod.POST)
    public ModelAndView editEmployee(Employee employee){
        employeeService.editEmployeeDetails(employee.getId(),employee.getEmployeeName(),employee.getEmployeeSurname());
        return new ModelAndView("employeeViews/editEmployeeConfirmation");
    }

    //REMOVE EMPLOYEE
    @RequestMapping (value="remove-employee.html", method=RequestMethod.GET)
    public ModelAndView removeEmployee(@RequestParam (name="id") Integer id){
        ModelAndView modelAndView = new ModelAndView("employeeViews/removeEmployee");
        employeeService.removeEmployee(id);
        return modelAndView;
    }

    //FIND EMPLOYEE BY SURNAME POST LIST
    @PostMapping(value = "find-employee-surname.html")
    public ModelAndView showEmployeeBySurnameDetailsList(@ModelAttribute Employee employee) {
        List<Employee> employeeList = employeeService.findEmployeeBySurnameList(employee.getEmployeeSurname());
        return new ModelAndView("employeeViews/findEmployeeBySurnameDetails","employees",employeeList);
    }

    //FIND EMPLOYEE BY SURNAME GET
    @GetMapping(value ="find-employee-surname.html" )
    public ModelAndView showEmployeeBySurnameForm() {
        return new ModelAndView("employeeViews/findEmployeeBySurname","employee", new Employee());
    }


    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


}
