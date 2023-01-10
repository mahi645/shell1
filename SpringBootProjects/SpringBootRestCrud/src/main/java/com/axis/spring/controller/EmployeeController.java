package com.axis.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.axis.spring.exception.ResourceNotFoundException;
import com.axis.spring.model.Employee;
import com.axis.spring.repository.EmployeeRepository;

@RestController
@RequestMapping("/api/emp4")
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	//1.get all users
	@GetMapping
	public List<Employee> getAllEmployee(){
		return this.employeeRepository.findAll();
	}
		//2.user by id
	@GetMapping("/{id}")
	public Employee getEmployeeId(@PathVariable(value="id") Long employId) 
	{
		return this.employeeRepository.findById(employId).orElseThrow(()->new ResourceNotFoundException("User not found with id:" +employId));
		
	}
		//3.create user
	@PostMapping
	public Employee createEmployee(@RequestBody Employee employ) {
		return this.employeeRepository.save(employ);
	}
	
		//4.update user
	@PutMapping("/{id}")
	public Employee updateEmployee(@RequestBody Employee employ,@PathVariable("id")Long employeeId) {
		Employee existingEmployee=this.employeeRepository.findById(employeeId)
				.orElseThrow(()->new ResourceNotFoundException("user not found with id: "+employeeId));
		existingEmployee.setName(employ.getName());
		existingEmployee.setDept(employ.getDept());
		return this.employeeRepository.save(existingEmployee);
	}
		//5.delete user
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Employee>  deleteEmploye(@PathVariable("id")Long employeeId){
		Employee existingEmployee=this.employeeRepository.findById(employeeId)
				.orElseThrow(()->new ResourceNotFoundException("user not found with id: "+employeeId));
		this.employeeRepository.delete(existingEmployee);
		return ResponseEntity.ok().build();
		
	}
}
