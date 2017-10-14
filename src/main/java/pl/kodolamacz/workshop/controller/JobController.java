package pl.kodolamacz.workshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.kodolamacz.workshop.service.JobService;

/**
 * Created by Pingwinek on 2017-10-13.
 */
@Controller
public class JobController {

    JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    public void setJobService(JobService jobService) {
        this.jobService = jobService;
    }

    //EMPLOYEE INDEX
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


}
