package com.infinity.employeeCRUD.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infinity.employeeCRUD.dao.EmployeeDao;
import com.infinity.employeeCRUD.entity.Employee;
import com.infinity.employeeCRUD.service.EmployeeService;

import jakarta.transaction.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	private EmployeeDao employeeDao;
	
	@Autowired
	public EmployeeServiceImpl(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}



	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		return employeeDao.findAll();
	}



	@Override
	public Employee findById(int theId) {
		// TODO Auto-generated method stub
		return employeeDao.findById(theId);
	}



	@Transactional
	@Override
	public Employee save(Employee theEmployee) {
		// TODO Auto-generated method stub
		return employeeDao.save(theEmployee);
	}


	@Transactional
	@Override
	public void deleteById(int theId) {
		// TODO Auto-generated method stub
		employeeDao.deleteById(theId);
		
	}

}
