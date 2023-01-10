package com.axis.spring.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/employee")
public class EmployeeController {
	ArrayList<Employee> employees=new ArrayList<Employee>();
	public EmployeeController() {
		employees.add(new Employee(1,"uma","hr"));
		employees.add(new Employee(2,"anu","developer"));
		
	}
	@GetMapping("/employees")
	public List<Employee> getAllEmployee(){
		return employees;
	}
	
	
	
}
