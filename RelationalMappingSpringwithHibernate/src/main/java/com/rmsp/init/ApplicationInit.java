package com.rmsp.init;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.rmsp.config.ApplicationDbConfig;
import com.rmsp.config.ApplicationWebMvcConfig;

public class ApplicationInit extends AbstractAnnotationConfigDispatcherServletInitializer{
	//DBConfig File input to FrontController
	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] {ApplicationDbConfig.class};
	}
    // for MVC Configuration
	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] {ApplicationWebMvcConfig.class};
	}
    // For Url Mappings
	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[] {"/"};
	}

}
