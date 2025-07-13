package com.employeeapp.model;

import java.util.Set;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data



public class EmployeeDto {
	
private String employeeName;

private Integer employeeId;

@ManyToMany
private Set<CourseDto> courses;
}
