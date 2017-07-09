package pl.kodolamacz.workshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import pl.kodolamacz.workshop.entity.Employee;
import pl.kodolamacz.workshop.service.EmployeeService;

import javax.jws.WebParam;
import javax.validation.Valid;

@Controller
public class EmployeeController {


    private EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    //EMPLOYEE INDEX
    @RequestMapping("employee-index.html")
    public ModelAndView getEmployeeIndex() {
        ModelAndView modelAndView = new ModelAndView("employeeIndex");
        return modelAndView;
    }
    //SHOW EMPLOYEES
    @RequestMapping("show-employees.html")
    public ModelAndView getAllEmployee() {
        ModelAndView modelAndView = new ModelAndView("employees");
        modelAndView.addObject("employees", employeeService.findAllEmployee());
        return modelAndView;
    }

    //ADD EMPLOYEE GET METHOD
    @RequestMapping(value = "add-employee.html", method = RequestMethod.GET)
    public ModelAndView showAddEmployeeForm(@RequestParam(name = "id") Integer id) {

        return new ModelAndView("addEmployee","employee", new Employee());

    }
    //ADD EMPLOYEE POST METHOD
    @RequestMapping(value = "add-employee.html", method = RequestMethod.POST)
    public ModelAndView addEmployee(@Valid @ModelAttribute Employee employee, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("addEmployee");
        }
        employeeService.addEmployee(employee);
        return new ModelAndView("addEmployeeConfirmation", "employee", employee);
    }

    //EDIT EMPLOYEE GET METHOD
    @RequestMapping (value ="edit-employee.html", method = RequestMethod.GET)
    public ModelAndView showEditEmployee(@RequestParam(name="id")Integer id){
        ModelAndView modelAndView = new ModelAndView("editEmployee");
        modelAndView.addObject(employeeService.findEmployeeById(id));
        return modelAndView;
    }

    //EDIT EMPLOYEE POST METHOD
    @RequestMapping (value="edit-employee.html", method =RequestMethod.POST)
    public ModelAndView editEmployee(Employee employee){
        employeeService.editEmployeeName(employee.getId(),employee.getEmployeeName());
        employeeService.editEmployeeSurname(employee.getId(),employee.getEmployeeName());
        return new ModelAndView("editEmployeeConfirmation");
    }




    public EmployeeService getEmployeeService() {
        return employeeService;
    }

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


}
