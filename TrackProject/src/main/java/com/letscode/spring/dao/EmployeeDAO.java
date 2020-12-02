package com.letscode.spring.dao;

import java.util.List;

import com.letscode.spring.entity.Employee;

public interface EmployeeDAO {
	
	public List<Employee> getEmployees();

	public void saveEmployee(Employee mainEmployee);

	public Employee getEmployee(int mainId);

	public void deleteEmployee(int mainId);
	
	
	
}
