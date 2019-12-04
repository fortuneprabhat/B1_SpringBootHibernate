package com.employee.dao;

import java.util.List;

import com.employee.entities.Employee;

public interface EmployeeDao {
	public void addEmployee(Employee employee);
	public List<Employee> getAllEmployee();
	public Employee findEmployeeById(Long adhar);
	public Employee update(Employee employee, Long adhar);
	public void deleteUserById(Long adhar);
}
