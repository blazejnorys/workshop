package pl.kodolamacz.workshop.dao;

import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import pl.kodolamacz.workshop.entity.Job;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by Pingwinek on 2017-07-04.
 */
@Repository
public class JobDaoImpl implements JobDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Job> findAllJobs() {
        return entityManager.createQuery("select j from Job j order by j.id", Job.class)
                .getResultList();
    }

    @Override
    public Job addJob(Job job) {
        entityManager.persist(job);
        entityManager.flush();
        entityManager.refresh(job);
        return job;

    }
}
