package com.employeeapp.model;

import org.hibernate.annotations.GeneratorType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
}
