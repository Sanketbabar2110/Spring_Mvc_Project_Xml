package com.pro.wings.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pro.wings.dao.EmployeeDao;
import com.pro.wings.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDao empDao;
	
	@Override
	public boolean createEmployee(Employee emp) {
		
		return empDao.createEmployee(emp);
	}

	@Override
	public List<Employee> getAllEmployee() {
	
		return empDao.getAllEmployee();
	}

}
