package com.employeeapp.model;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString(exclude = "employees")
public class DepartmentDto {
	
	private String departmentName;
	
	private Integer departmentId;
	
	private Set<Employee> employees;
	
	public DepartmentDto(String departmentName) {
		super();
		this.departmentName = departmentName;
	}

	
}
