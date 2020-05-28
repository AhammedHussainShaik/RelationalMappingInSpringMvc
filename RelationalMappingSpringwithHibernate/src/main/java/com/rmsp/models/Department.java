package com.rmsp.models;

import java.util.List;
import com.rmsp.models.Employee;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString.Exclude;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="project_depttab")
public class Department {
	@Id
	@GeneratedValue
	private Integer deptId;
	private String deptName;
	
	@Exclude
	@OneToMany(mappedBy = "dept",fetch = FetchType.EAGER)
	private List<Employee> employees;
	

}
