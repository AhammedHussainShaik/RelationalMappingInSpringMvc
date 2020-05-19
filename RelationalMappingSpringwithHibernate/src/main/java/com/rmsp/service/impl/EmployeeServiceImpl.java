package com.rmsp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rmsp.dao.IEmployeeDao;
import com.rmsp.models.Employee;
import com.rmsp.service.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
	@Autowired
	IEmployeeDao employeeDao;

	@Override
	public Integer saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeDao.saveEmployee(employee);
	}

	@Override
	public List<Employee> getAllDeptConectedEmployees() {
		// TODO Auto-generated method stub
		return employeeDao.getAllDeptConectedEmployees();
	}

}
