package com.infinity.employeeCRUD.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.infinity.employeeCRUD.dao.EmployeeDao;
import com.infinity.employeeCRUD.entity.Employee;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
	
	private EmployeeDao employeeDao;

	public EmployeeRestController(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
	
	@GetMapping("/employees")
	public List<Employee> findAll(){
		return employeeDao.findAll();
	}
	
	

}
