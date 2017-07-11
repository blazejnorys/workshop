package pl.kodolamacz.workshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import pl.kodolamacz.workshop.entity.Customer;
import pl.kodolamacz.workshop.service.CustomerService;

import javax.validation.Valid;

/**
 * Created by Pingwinek on 2017-07-11.
 */
@Controller
public class CustomerController {

    private CustomerService customerService;
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    //EMPLOYEE INDEX
    @RequestMapping("customer-index.html")
    public ModelAndView getCustomerIndex() {
        ModelAndView modelAndView = new ModelAndView("customerViews/customerIndex");
        return modelAndView;
    }
    //SHOW EMPLOYEES
    @RequestMapping("show-customers.html")
    public ModelAndView getAllCustomer() {
        ModelAndView modelAndView = new ModelAndView("customerViews/customers");
        modelAndView.addObject("customers", customerService.findAllCustomer());
        return modelAndView;
    }

    //ADD EMPLOYEE GET METHOD
    @RequestMapping(value = "add-customer.html", method = RequestMethod.GET)
    public ModelAndView showAddCustomerForm() {

        return new ModelAndView("customerViews/addCustomer","customer", new Customer());

    }
    //ADD EMPLOYEE POST METHOD
    @RequestMapping(value = "add-customer.html", method = RequestMethod.POST)
    public ModelAndView addCustomer(@Valid @ModelAttribute Customer customer, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ModelAndView("customerViews/addCustomer");
        }
        customerService.addCustomer(customer);
        return new ModelAndView("customerViews/addCustomerConfirmation", "customer", customer);
    }

    //EDIT EMPLOYEE GET METHOD
    @RequestMapping (value ="edit-customer.html", method = RequestMethod.GET)
    public ModelAndView showEditCustomer(@RequestParam(name="id")Integer id){
        ModelAndView modelAndView = new ModelAndView("customerViews/editCustomer");
        modelAndView.addObject(customerService.findCustomerById(id));
        return modelAndView;
    }

    //EDIT EMPLOYEE POST METHOD
    @RequestMapping (value="edit-customer.html", method =RequestMethod.POST)
    public ModelAndView editCustomer(Customer customer){
        customerService.editCustomerDetails(customer.getId(),customer.getCustomerName(),customer.getCustomerSurname(),customer.getCar(),customer.getPhonenumber());
        return new ModelAndView("customerViews/editCustomerConfirmation");
    }

    //REMOVE EMPLOYEE
    @RequestMapping(value="remove-customer.html", method= RequestMethod.GET)
    public ModelAndView removeCustomer(@RequestParam(name="id") Integer id){
        ModelAndView modelAndView = new ModelAndView("customerViews/removeCustomer");
        customerService.removeCustomer(id);
        return modelAndView;
    }




    public CustomerService getCustomerService() {
        return customerService;
    }

    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

}
