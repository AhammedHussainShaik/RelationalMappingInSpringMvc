package com.rmsp.dao;

import java.util.List;

import com.rmsp.models.Department;

public interface IDepartmentDao {
	// to save Department in DB
	public Integer saveDepartment(Department department);
	
	public List<Department> getAllDepartments();

}
