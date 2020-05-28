package com.rmsp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.rmsp.formatters.DepartmentFarmatter;

@Configuration
@EnableWebMvc
@PropertySource("classpath:application.properties")
@ComponentScan("com.rmsp")
public class ApplicationWebMvcConfig implements WebMvcConfigurer {
	@Autowired
	Environment environment;
	
	@Bean
	public InternalResourceViewResolver internalResourceViewResolver() {
		InternalResourceViewResolver viewResolver=new InternalResourceViewResolver();
		viewResolver.setPrefix(environment.getProperty("mvc.prefix"));
		viewResolver.setSuffix(environment.getProperty("mvc.suffix"));
		
		return viewResolver;
	} 
	@Override
	public void addFormatters(FormatterRegistry registry) {
	registry.addFormatter(new DepartmentFarmatter());
	}
	

}
