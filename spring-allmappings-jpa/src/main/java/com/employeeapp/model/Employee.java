package com.employeeapp.model;

import java.util.Set;

import org.hibernate.annotations.GeneratorType;
import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Employee {
	@Column(length=30)
private String employeeName;
@Id
@GeneratedValue(generator="emp_gen",strategy=GenerationType.AUTO)
@SequenceGenerator(name="emp_gen",sequenceName ="emp_seq",initialValue = 1 )
private Integer employeeId;

@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
@JoinTable(name="empl_courses"
			,joinColumns = @JoinColumn(name="employee_id")
			,inverseJoinColumns = @JoinColumn(name="course_id"))

private Set<Course> courses;
}
