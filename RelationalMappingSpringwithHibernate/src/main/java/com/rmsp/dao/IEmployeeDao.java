package com.rmsp.dao;

import java.util.List;

import com.rmsp.models.Employee;

public interface IEmployeeDao {
	// to Save One employee in DB
	public Integer saveEmployee(Employee employee);
	
	// To Fetch All Connected Employees
	public List<Employee> getAllDeptConectedEmployees();

}
