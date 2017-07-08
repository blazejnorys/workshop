package pl.kodolamacz.workshop.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.kodolamacz.workshop.hibernate.model.Employee;

import javax.annotation.Resource;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

/**
 * Created by Pingwinek on 2017-07-04.
 */
@Repository
@Transactional
public class EmployeeDaoImpl implements EmployeeDao {
    
    @Resource
    private SessionFactory sessionFactory;

    @Override
    public List<Employee> findAllEmployee() {
        CriteriaBuilder cB = getCurrentSession().getCriteriaBuilder();

        CriteriaQuery<Employee> cQ = cB.createQuery(Employee.class);
        cQ.from(Employee.class);
        
        return getCurrentSession().createQuery(cQ).list();
    }



    @Override
    public void addEmployee(Employee employee) {
        getCurrentSession().persist(employee);

    }

    private Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}
