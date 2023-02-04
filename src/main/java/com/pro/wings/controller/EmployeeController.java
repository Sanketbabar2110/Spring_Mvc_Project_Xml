package com.pro.wings.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.pro.wings.entity.Employee;
import com.pro.wings.service.EmployeeService;

@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeService service;
	
	@Autowired
	Employee emp;

	@RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
	public ModelAndView addEmployee(@RequestParam("name") String name, @RequestParam("salary")String salary) {
		
		emp.setName(name);
		emp.setSalary(Integer.parseInt(salary));
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("welcome");
		
		String res = null;
		
		if(service.createEmployee(emp)) {
			
			res = "Employee added successfully!!!";
			mv.addObject("res", res);
			
		}else {
			
			res = "Issue in adding Employee!!!";
			mv.addObject("res", res);
		}
		return mv;
	}
	
	@RequestMapping(value = "/GetAll", method = RequestMethod.GET)
	public ModelAndView getAllEmployee() {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("welcome");
		
		String res = service.getAllEmployee().toString();
		
		return mv;
	}
}
