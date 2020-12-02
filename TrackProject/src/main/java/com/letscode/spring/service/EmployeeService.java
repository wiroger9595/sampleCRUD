package com.letscode.spring.service;

import java.util.List;

import com.letscode.spring.entity.Employee;

public interface EmployeeService {

	public List<Employee> getEmployees();

	public void saveEmployee(Employee mainEmployee);

	public Employee getEmployee(int mainId);

	void deleteEmployee(int mainId);
	
	
}
