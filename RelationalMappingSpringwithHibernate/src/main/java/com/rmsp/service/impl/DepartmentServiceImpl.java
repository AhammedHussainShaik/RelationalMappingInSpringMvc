package com.rmsp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rmsp.models.Department;
import com.rmsp.service.IDepartmentService;

@Service
public class DepartmentServiceImpl implements IDepartmentService {
	@Autowired
	IDepartmentService deptService;

	@Override
	public Integer saveDepartment(Department department) {
		// TODO Auto-generated method stub
		return deptService.saveDepartment(department);
	}

	@Override
	public List<Department> getAllDepartments() {
		// TODO Auto-generated method stub
		return deptService.getAllDepartments();
	}

}
