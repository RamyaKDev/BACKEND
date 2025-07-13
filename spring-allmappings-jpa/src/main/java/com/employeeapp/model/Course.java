package com.employeeapp.model;

import java.util.Set;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Course {
	@Column(length=30)
private String courseName;
	@Id
	@GeneratedValue(generator = "course_gen",strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "course_gen",sequenceName = "course_seq",initialValue = 51)
	private Integer courseId;
	private double fees;
	private String type;//technical, softskill
	private String mode;//online, offline
	
	@ManyToMany(mappedBy = "courses")
	private Set<Employee> employees;
}
