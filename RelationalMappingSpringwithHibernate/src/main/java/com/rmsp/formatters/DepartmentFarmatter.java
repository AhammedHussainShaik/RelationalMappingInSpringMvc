package com.rmsp.formatters;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

import com.rmsp.models.Department;

public class DepartmentFarmatter implements Formatter<Department> {

	@Override
	public String print(Department department, Locale locale) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Department parse(String s, Locale locale) throws ParseException {
		// TODO Auto-generated method stub
		System.out.println(s);
		Department department=new Department();
		department.setDeptId(Integer.parseInt(s));
		return department;
	}

}
