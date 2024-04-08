package com.infinity.employeeCRUD.dao;

import java.util.List;

import com.infinity.employeeCRUD.entity.Employee;

public interface EmployeeDao {
	List<Employee> findAll();
	
	Employee findById(int theId);
	
	Employee save(Employee theEmployee);
	
	void deleteById(int theId);

}
