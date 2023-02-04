package com.pro.wings.service;

import java.util.List;

import com.pro.wings.entity.Employee;

public interface EmployeeService {

	boolean createEmployee(Employee emp);
	
	List<Employee> getAllEmployee();
}
