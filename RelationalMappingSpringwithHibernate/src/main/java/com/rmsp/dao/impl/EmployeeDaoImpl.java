package com.rmsp.dao.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rmsp.dao.IEmployeeDao;
import com.rmsp.models.Employee;
@Repository
public class EmployeeDaoImpl implements IEmployeeDao {
	@Autowired
	HibernateTemplate hibernateTemplate;

	@Override
	@Transactional
	public Integer saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return (Integer) hibernateTemplate.save(employee);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Employee> getAllDeptConectedEmployees() {
		List<Employee> employees=hibernateTemplate.execute(new HibernateCallback<List<Employee>>() {
			@SuppressWarnings("unused")
			@Override
			public List<Employee> doInHibernate(Session session) throws HibernateException {
				CriteriaBuilder builder=session.getCriteriaBuilder();
				CriteriaQuery<Employee> criteriaQuery=builder.createQuery(Employee.class);
				Root<Employee> root=criteriaQuery.from(Employee.class);
				Join<Object, Object> join=root.join("department", JoinType.INNER);
				criteriaQuery.select(root);

				Query<Employee> query= session.createQuery(criteriaQuery);
				List<Employee> employees=query.list();

				return employees;
			}
		});
		return employees;
	}

}
