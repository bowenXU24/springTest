package com.box.springboot.thymeleaf.service;

import java.util.List;

import com.box.springboot.thymeleaf.entity.Employee;

public interface EmployeeService {
	
	public List<Employee> findAll();
	
	public Employee findById(int theId); 
		
	public void save(Employee theEmployee);

	public void deleteById(int thdId);

}
