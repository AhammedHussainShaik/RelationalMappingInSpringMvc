package com.rmsp.service;

import java.util.List;

import com.rmsp.models.Department;
import com.rmsp.models.Employee;

public interface IDepartmentService {
	// to save Department in DB
		public Integer saveDepartment(Department department);
		
		public List<Department> getAllDepartments();
		
		public List<Department> getAlDepartmentsConectedEmployee();

}
