package com.rmsp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.rmsp.models.Department;
import com.rmsp.service.IDepartmentService;

@Controller
public class DepartmentController {
	@Autowired
	IDepartmentService service;
	String message;

	@RequestMapping("/")
	public ModelAndView homePage() {
		ModelAndView view=new ModelAndView();
		view.setViewName("menu");
		return view;
	}

	@RequestMapping("/deptRegister")
	public ModelAndView showDeptRegisterPage(Model model) {
		model.addAttribute("department", new Department());
		
		ModelAndView view=new ModelAndView();
		view.setViewName("departmentRegisterPage");
		return view;
	}
	@RequestMapping("/saveDepartment")
	public ModelAndView saveDepartment(@ModelAttribute Department department,Model model ) {
		Integer id=service.saveDepartment(department);
		model.addAttribute("message", "saved Department with Id :"+id);
		model.addAttribute("department", new Department());
		
		ModelAndView view=new ModelAndView();
		view.setViewName("departmentRegisterPage");
		
		return view;
		
	}

}
