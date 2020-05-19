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

import com.rmsp.dao.IDepartmentDao;
import com.rmsp.models.Department;

@Repository
public class DepartmentDaoImpl implements IDepartmentDao {
	@Autowired
	HibernateTemplate hibernateTemplate;


	@Override
	public Integer saveDepartment(Department department) {

		return (Integer) hibernateTemplate.save(department);
	}

	@Override
	public List<Department> getAllDepartments() {
		List<Department> departments=hibernateTemplate.execute(new HibernateCallback<List<Department>>() {
			@SuppressWarnings("unused")
			@Override
			public List<Department> doInHibernate(Session session) throws HibernateException {
				CriteriaBuilder builder=session.getCriteriaBuilder();
				CriteriaQuery<Department> criteriaQuery=builder.createQuery(Department.class);
				Root<Department> root=criteriaQuery.from(Department.class);
				Join<Object, Object> join=root.join("employees",JoinType.INNER);
				criteriaQuery.select(root);

				Query<Department> query=session.createQuery(criteriaQuery);
				List<Department> departments=query.list();
				return departments;
			}
		});
		return departments;
	}

}
