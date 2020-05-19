package com.rmsp.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.rmsp.models.Department;

import org.hibernate.annotations.Cascade;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="proj_employee")
public class Employee {
	@Id
	@GeneratedValue
	private Integer empId;
	private String empName;
	private Double empSalary;
	
	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private Department dept;

}
