package com.employee.service;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.dao.EmployeeDao;
import com.employee.entities.Employee;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao;
	
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void addEmployee(Employee employee) {
		employeeDao.addEmployee(employee);

	}

	@Override
	public List<Employee> getEmployees() {
		List<Employee> emp= employeeDao.getAllEmployee();
		return emp;
	}

	@Override
	public Employee findEmployeeById(Long adhar) {
		return employeeDao.findEmployeeById(adhar);
	}

	@Override
	public Employee update(Employee employee, Long adhar) {
		
		return employeeDao.update(employee, adhar);
	}

	@Override
	public void deleteUserById(Long adhar) {
		 employeeDao.deleteUserById(adhar);
		
	}

}
