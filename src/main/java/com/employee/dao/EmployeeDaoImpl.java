package com.employee.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.employee.entities.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void addEmployee(Employee employee) {
		Session session = sessionFactory.getCurrentSession();
	    session.save(employee);
	    
	}


	@Override
	public List<Employee> getAllEmployee() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaQuery<Employee> criteriaQuery = session.getCriteriaBuilder().createQuery(Employee.class);
        criteriaQuery.from(Employee.class);

        List<Employee> employees = session.createQuery(criteriaQuery).getResultList();
        return employees;
        //session.close();
	}


	@Override
	public Employee findEmployeeById(Long adhar) {
		Session session = sessionFactory.getCurrentSession();
		Employee employee=(Employee) session.get(Employee.class,adhar);
        return employee;
	}


	@Override
	public Employee update(Employee employee, Long adhar) {
		Session session = sessionFactory.getCurrentSession();
		session.update(employee);
		return employee;
	}


	@Override
	public void deleteUserById(Long adhar) {
		Session session = sessionFactory.getCurrentSession();
		session.delete((Employee) findEmployeeById(adhar));
		
	}
}
