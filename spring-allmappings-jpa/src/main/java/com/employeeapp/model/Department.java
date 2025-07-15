package com.employeeapp.model;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@ToString(exclude = "employees")
public class Department {
	@Column(length = 20)
	private String departmentName;
	@Id
	@GeneratedValue(generator ="department_gen", strategy = GenerationType.AUTO )
	@SequenceGenerator(name = "department_gen",sequenceName = "department_seq", initialValue = 21)
	private Integer departmentId;
	
	public Department(String departmentName) {
		super();
		this.departmentName = departmentName;
	}
	@OneToMany(mappedBy = "department")
	private Set<Employee> employees;
}
