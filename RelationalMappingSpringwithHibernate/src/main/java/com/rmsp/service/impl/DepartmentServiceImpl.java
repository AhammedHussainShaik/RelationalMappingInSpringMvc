package com.rmsp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rmsp.dao.IDepartmentDao;
import com.rmsp.models.Department;
import com.rmsp.models.Employee;
import com.rmsp.service.IDepartmentService;

@Service
public class DepartmentServiceImpl implements IDepartmentService {
	@Autowired
	IDepartmentDao deptDao;

	@Override
	public Integer saveDepartment(Department department) {
		// TODO Auto-generated method stub
		return deptDao.saveDepartment(department);
	}

	@Override
	public List<Department> getAlDepartmentsConectedEmployee() {
		// TODO Auto-generated method stub
		return deptDao.getAlDepartmentsConectedEmployee();
	}

	@Override
	public List<Department> getAllDepartments() {
		// TODO Auto-generated method stub
		return deptDao.getAllDepartments();
	}

}
