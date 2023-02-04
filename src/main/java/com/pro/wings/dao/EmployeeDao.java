package com.pro.wings.dao;

import java.util.List;

import com.pro.wings.entity.Employee;

public interface EmployeeDao {

	boolean createEmployee(Employee emp);
	
	List<Employee> getAllEmployee();
}
