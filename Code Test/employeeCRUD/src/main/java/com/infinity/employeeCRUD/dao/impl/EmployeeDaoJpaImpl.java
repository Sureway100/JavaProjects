package com.infinity.employeeCRUD.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.infinity.employeeCRUD.dao.EmployeeDao;
import com.infinity.employeeCRUD.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class EmployeeDaoJpaImpl implements EmployeeDao{
	
	private EntityManager entityManager;
	
	@Autowired
	public EmployeeDaoJpaImpl (EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	@Override
	public List<Employee> findAll() {
		// TODO Auto-generated method stub
		
		//create a query
		
		TypedQuery<Employee> theQuery = entityManager.createQuery("from Employee", Employee.class);
		
		//execute query and get result list
		List<Employee> employees = theQuery.getResultList();
		
		//return the results
		return employees;
		

	}

}
