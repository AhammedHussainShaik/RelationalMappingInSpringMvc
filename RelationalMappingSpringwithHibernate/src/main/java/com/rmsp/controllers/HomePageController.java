package com.rmsp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomePageController {
	@RequestMapping("/")
	public ModelAndView homePage() {
		ModelAndView view=new ModelAndView();
		view.setViewName("menu");
		return view;
	}

}
