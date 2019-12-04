package com.employee.service;

import java.util.List;

import com.employee.entities.Employee;

public interface EmployeeService {
	public void addEmployee(Employee employee);
    public List<Employee> getEmployees();
    public Employee findEmployeeById(Long adhar);
    public Employee update(Employee employee, Long adhar);
    public void deleteUserById(Long adhar);
//    public Employee updatePartially(Employee user, Integer id);
}
