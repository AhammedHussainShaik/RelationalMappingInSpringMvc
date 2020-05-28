package com.rmsp.dao;

import java.util.List;

import com.rmsp.models.Department;
import com.rmsp.models.Employee;

public interface IDepartmentDao {
	// to save Department in DB
	public Integer saveDepartment(Department department);
	
	public List<Department> getAllDepartments();
	
	public List<Department> getAlDepartmentsConectedEmployee();

}
