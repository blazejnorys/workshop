package pl.kodolamacz.workshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import pl.kodolamacz.workshop.model.Employee;
import pl.kodolamacz.workshop.service.EmployeeService;

import javax.validation.Valid;

@Controller
public class EmployeeController {


    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping("show-employees.html")
    public ModelAndView getAllEmployee() {
        ModelAndView modelAndView = new ModelAndView("employees");
        modelAndView.addObject("employees", employeeService.findAllEmployee());
        return modelAndView;
    }

    @RequestMapping(value = "employee.html", method = RequestMethod.GET)
    public ModelAndView showAddProductForm(@RequestParam(name = "id", required = false) Integer id) {
//        if (id != null) {
//            ModelAndView modelAndView = new ModelAndView("edit");
//            modelAndView.addObject(employeeService.findProduct(id));
//            return modelAndView;
//        }
        ModelAndView modelAndView = new ModelAndView("addEmployee");
        modelAndView.addObject(new Employee());
        return modelAndView;
    }

    @RequestMapping(value = "employee.html", method = RequestMethod.POST)
    public ModelAndView addProduct(@Valid @ModelAttribute Employee employee, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("addEmployee");
        }
        employeeService.addEmployee(employee);
        return new ModelAndView("addEmployeeConfirmation", "employee", employee);
    }

}
