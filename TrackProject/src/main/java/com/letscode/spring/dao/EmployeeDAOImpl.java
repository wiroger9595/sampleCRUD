package com.letscode.spring.dao;

import java.nio.channels.SeekableByteChannel;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.context.spi.CurrentSessionContext;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.letscode.spring.entity.Employee;


@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

	
	
	// need to inject the session factory
	
	@Autowired(required = true)
	private SessionFactory sessionFactory;
	
	
	
	
	
	@Override
	public List<Employee> getEmployees() {

		// get the current hibernate session
		Session nowSession = sessionFactory.getCurrentSession();
		
		// create a query
		Query<Employee> theQuery = nowSession.createQuery("from Employee order by lastName", Employee.class);
		
		
		// execute query and get result list
		List<Employee> employees = theQuery.getResultList();
		
		// return the results
		
		
		
		
		return employees;
	}





	@Override
	public void saveEmployee(Employee mainEmployee) {
		// TODO Auto-generated method stub
		
		// get current hibernate session
		Session nowSession = sessionFactory.getCurrentSession();
		
		
		
		// save the employee ... final, if you use save you will add new column
		// so use saveOrUpdate for real update
		nowSession.saveOrUpdate(mainEmployee);
		
	}





	@Override
	public Employee getEmployee(int mainId) {

		//get current hibernate session
		Session nowSession = sessionFactory.getCurrentSession();
		
		
		// now retrieve / read from database using the primary key
		Employee mainEmployee = nowSession.get(Employee.class, mainId);
		
		
		return mainEmployee;
	}





	@Override
	public void deleteEmployee(int mainId) {

		// get the current hibernate session
		Session nowSession = sessionFactory.getCurrentSession();
		
		// delete object with primary key
		Query mainQuery = nowSession.createQuery("delete from Employee where id=:employeeId");
		
		// param have to match
		mainQuery.setParameter("employeeId", mainId);
		
		
		mainQuery.executeUpdate();
		
	}

	
	
}
