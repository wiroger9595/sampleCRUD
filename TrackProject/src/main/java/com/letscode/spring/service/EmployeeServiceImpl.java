package com.letscode.spring.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.letscode.spring.dao.EmployeeDAO;
import com.letscode.spring.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	// need to inject employee dao
	
	@Autowired(required = true)
	private EmployeeDAO employeeDAO;
	
	@Override
	@Transactional
	public List<Employee> getEmployees() {
		// TODO Auto-generated method stub
		return employeeDAO.getEmployees();
	}

	@Override
	@Transactional
	public void saveEmployee(Employee mainEmployee) {
		// TODO Auto-generated method stub
		employeeDAO.saveEmployee(mainEmployee);
	}

	@Override
	@Transactional
	public Employee getEmployee(int mainId) {
		// TODO Auto-generated method stub
		return employeeDAO.getEmployee(mainId);
	}

	@Override
	@Transactional
	public void deleteEmployee(int mainId) {
		// TODO Auto-generated method stub
		
		employeeDAO.deleteEmployee(mainId);
	}

	

}
