package com.employeeapp.model;

import java.util.Set;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@ToString(exclude="employees")
public class Course {
	@Column(length=20)
	private String courseName;
	@Id
	@GeneratedValue(generator = "course_gen",strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "course_gen",sequenceName = "course_seq",initialValue = 101)
	private Integer courseId;
	
	private double fees;
	private String type; //technical or softskills
	private String mode; //online or offline
	
	@ManyToMany(mappedBy = "courses")
	private Set<Employee> employees;

	public Course(String courseName, Integer courseId, double fees, String type, String mode) {
		super();
		this.courseName = courseName;
		this.courseId = courseId;
		this.fees = fees;
		this.type = type;
		this.mode = mode;
	}
	
}
