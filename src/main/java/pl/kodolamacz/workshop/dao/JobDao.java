package pl.kodolamacz.workshop.dao;

import pl.kodolamacz.workshop.entity.Job;

import java.util.List;

/**
 * Created by Pingwinek on 2017-07-04.
 */
public interface JobDao {

    List<Job> findAllJobs();

    Job addJob(Job job);

}
