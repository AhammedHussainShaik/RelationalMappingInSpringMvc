package com.rmsp.service;

import java.util.List;

import com.rmsp.models.Employee;

public interface IEmployeeService {
	// to Save One employee in DB
		public Integer saveEmployee(Employee employee);
		
		// To Fetch All Connected Employees
		public List<Employee> getAllDeptConectedEmployees();

}
