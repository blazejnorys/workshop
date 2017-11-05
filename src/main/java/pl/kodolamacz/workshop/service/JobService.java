package pl.kodolamacz.workshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.kodolamacz.workshop.dao.*;
import pl.kodolamacz.workshop.dao.CustomerDao;
import pl.kodolamacz.workshop.dao.EmployeeDao;
import pl.kodolamacz.workshop.entity.Job;

import java.beans.Transient;
import java.util.List;

/**
 * Created by Pingwinek on 2017-07-04.
 */
@Service
@Transactional
public class JobService {


    private JobDao jobDao;

    public List<Job> findAllJobs(){
        return jobDao.findAllJobs();
    }

    public Job addNewJob(Job job){return jobDao.addJob(job);}

    public JobService(JobDao jobDao) {
        this.jobDao = jobDao;
    }

}
