package com.infinity.employeeCRUD.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infinity.employeeCRUD.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
