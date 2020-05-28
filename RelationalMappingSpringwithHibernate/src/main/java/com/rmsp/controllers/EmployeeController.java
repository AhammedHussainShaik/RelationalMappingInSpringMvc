package com.rmsp.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import com.rmsp.models.Employee;
import com.rmsp.models.Department;
import com.rmsp.service.IDepartmentService;
import com.rmsp.service.IEmployeeService;

@Controller
public class EmployeeController {
	@Autowired
	IEmployeeService empService;
	@Autowired
	IDepartmentService deptService;
	
	@RequestMapping("/empRegister")
	public ModelAndView showEmpRegisterPage(Model model) {
		List<Department> departments=deptService.getAllDepartments();
		model.addAttribute("employee",new Employee());
		
		model.addAttribute("departments", departments);
		ModelAndView view=new ModelAndView();
		view.setViewName("employeeRegister");
		return view;
	}
	@RequestMapping("/saveEmp")
	public ModelAndView saveEmployee(@ModelAttribute Employee employee,Model model) {
		
		/*
		 * Department department=new Department();
		 * department.setEmployees(Arrays.asList(employee));
		 * employee.setDept(department);
		 */
		 
		empService.saveEmployee(employee);
		
		model.addAttribute("employee", new Employee());
		model.addAttribute("message", "Employee Saved..");
		
		ModelAndView view=new ModelAndView();
		view.setViewName("employeeRegister");
		return view;
	}

}
