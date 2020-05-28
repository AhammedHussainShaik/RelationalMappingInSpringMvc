package com.rmsp.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.rmsp.models.Department;
import com.rmsp.models.Employee;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
public class ApplicationDbConfig {
	@Autowired
	Environment environment;
	
	@Bean
	public DriverManagerDataSource dataSource() {
		DriverManagerDataSource source=new DriverManagerDataSource();
		source.setDriverClassName(environment.getProperty("db.driver"));
		source.setUrl(environment.getProperty("db.url"));
		source.setUsername(environment.getProperty("db.user"));
		source.setPassword(environment.getProperty("db.pwd"));
		return source;
	}
	
	@Bean
	public LocalSessionFactoryBean sessionFactoryBean() {
		LocalSessionFactoryBean sessionFactoryBean=new LocalSessionFactoryBean();
		
		sessionFactoryBean.setDataSource(dataSource());
		/*
		 * sessionFactoryBean.setAnnotatedClasses(Employee.class);
		 * sessionFactoryBean.setAnnotatedClasses(Department.class);
		 */
		sessionFactoryBean.setPackagesToScan("com.rmsp.models");
		sessionFactoryBean.setHibernateProperties(getProperties());
		
		return sessionFactoryBean;
	}
	
	@Bean
	public HibernateTemplate hibernateTemplate() {
		HibernateTemplate template=new HibernateTemplate();
		template.setSessionFactory(sessionFactoryBean().getObject());
		return template;
	}
	
	@Bean
	public HibernateTransactionManager hibernateTransactionManager() {
		HibernateTransactionManager transactionManager=new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactoryBean().getObject());
		return transactionManager;
	}
	
	private Properties getProperties() {
		Properties properties=new Properties();
		properties.put("hibernate.dialect", environment.getProperty("orm.dialect"));
		properties.put("hibernate.show_sql",environment.getProperty("orm.showsql"));
		properties.put("hibernate.format_sql", environment.getProperty("orm.fmtsql"));
		properties.put("hibernate.hbm2ddl.auto", environment.getProperty("orm.ddlauto"));
		return properties;
	}

}
