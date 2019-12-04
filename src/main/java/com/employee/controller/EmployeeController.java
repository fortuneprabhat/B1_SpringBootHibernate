package com.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee.entities.Employee;
import com.employee.service.EmployeeService;

/**
 * 
 * @author prabhatkumar
 * http://candidjava.com/tutorial/spring-boot-hibernate-crud-example/
 *
 */

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	
	@PostMapping(path = "/employee", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
		employeeService.addEmployee(employee);
		return new ResponseEntity<>(employee, HttpStatus.CREATED);
	}
	
	@GetMapping(path = "/employee", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Employee>> getEmployee(){
		//employeeService.addEmployee(employee);
		return new ResponseEntity<>(employeeService.getEmployees(), HttpStatus.FOUND);
	}
	
	@PutMapping(path = "/employee", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
		
		if(employeeService.findEmployeeById(employee.getAdhar())==null) {
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(employeeService.update(employee, employee.getAdhar()), HttpStatus.CREATED);
	}
	
	@DeleteMapping(path="/employee/{adhar}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Employee> deleteEmployee(@PathVariable long adhar){
		Employee employee =employeeService.findEmployeeById(adhar);
		if(employee==null) {
			return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		}
		employeeService.deleteUserById(employee.getAdhar());
		return new ResponseEntity<Employee>(HttpStatus.NO_CONTENT);
	}
}
