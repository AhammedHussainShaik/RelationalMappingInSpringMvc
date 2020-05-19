package com.rmsp.service;

import java.util.List;

import com.rmsp.models.Department;

public interface IDepartmentService {
	// to save Department in DB
		public Integer saveDepartment(Department department);
		
		public List<Department> getAllDepartments();

}
