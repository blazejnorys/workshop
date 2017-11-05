package pl.kodolamacz.workshop.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.apache.taglibs.standard.lang.jstl.EmptyOperator;
import org.slf4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import pl.kodolamacz.workshop.entity.Customer;
import pl.kodolamacz.workshop.entity.Employee;
import pl.kodolamacz.workshop.entity.Job;
import pl.kodolamacz.workshop.service.CustomerService;
import pl.kodolamacz.workshop.service.EmployeeService;
import pl.kodolamacz.workshop.service.JobService;

import javax.swing.*;
import java.util.List;

/**
 * Created by Pingwinek on 2017-10-13.
 */
@Controller
public class JobController {

    JobService jobService;
    EmployeeService employeeService;
    CustomerService customerService;

    public JobController(JobService jobService, EmployeeService employeeService, CustomerService customerService) {
        this.jobService = jobService;
        this.employeeService = employeeService;
        this.customerService = customerService;
    }

    //JOB INDEX
    @RequestMapping("job-index.html")
    public ModelAndView getJobIndex() {
        ModelAndView modelAndView = new ModelAndView("jobViews/jobIndex");
        return modelAndView;
    }
    //SHOW EMPLOYEES
    @RequestMapping("show-jobs.html")
    public ModelAndView getAllJobs() {
        ModelAndView modelAndView = new ModelAndView("jobViews/jobs");
        modelAndView.addObject("jobs", jobService.findAllJobs());
        return modelAndView;
    }

    //ADD NEW JOB GET METHOD
    @GetMapping(value = "add-job.html")
    public ModelAndView addNewJob(){
        return new ModelAndView("jobViews/addJob","job", new Job());
    }

    //ADD NEW JOB POST METHOD
    @PostMapping(value = "add-job.html")
    public ModelAndView addNewJob(@ModelAttribute Job job){
        return new ModelAndView("jobViews/addJobConfirmation","job",job);
    }

    @ModelAttribute("employeeInit")
    public List<Employee> initializeEmployees() {
        return employeeService.findAllEmployee();
    }

    @ModelAttribute("customerInit")
    public List<Customer> initializeCustomer(){ return customerService.findAllCustomer();}

}
