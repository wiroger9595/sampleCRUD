package com.letscode.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.letscode.spring.dao.EmployeeDAO;
import com.letscode.spring.entity.Employee;
import com.letscode.spring.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	
	// need to inject the employee dao (service layer 建立時，就該把單元定義放到 model layer)
	
//	@Autowired
//	private EmployeeDAO employeeDAO;
//	
	
	// ----------------------------------------------------------------------------
	
	// that's inject employee serivce
	
	@Autowired(required = true)
	private EmployeeService employeeService;
	
	
	@GetMapping("/list")
	public String listEmployee(Model model) {
		
		// get employee from the dao
		// 當有 service layer 就把單元層(dao layer) 給換掉
		List<Employee> mainEmployee = employeeService.getEmployees();
		
		
		
		// add the customers to the modal
		model.addAttribute("employees", mainEmployee);
		
		return "list-employee";
	}
	
	@GetMapping("/FormForAdd")
	public String FromForAdd(Model mainModel) {
		
		Employee mainEmployee = new Employee();
		
		mainModel.addAttribute("employee", mainEmployee);
		
		
		return "employee-form";
	}			
	
	
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employee mainEmployee) {
		
		// save employee using our service
		employeeService.saveEmployee(mainEmployee);
		
		
		
		
		return "redirect:/employee/list";
	}
	
	
	@GetMapping("/FormForUpdate")
	public String FormForUpdate(@RequestParam("employeeId") int mainId, Model mainModel)
	{
		// get the employee from the database
		Employee mainEmployee = employeeService.getEmployee(mainId);
		
		
		// set employee as a model attribute to pre-populate the form
		mainModel.addAttribute("employee", mainEmployee);
		
		// send over to our form
		
		return "employee-form";
				
	}
	
	
	@GetMapping("/FormForDelete")
	public String FormForDelete(@RequestParam("employeeId") int mainId, Model mainModel)
	{
		// delete the employee 
		employeeService.deleteEmployee(mainId);
		
		
		return "redirect:/employee/list";
	}
}
