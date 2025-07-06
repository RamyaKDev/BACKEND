package com.studentapp.model;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Student {
	@Column(length = 20)
	private String studentName;
	@Id
	@GeneratedValue(generator = "stud_gen",strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "stud_gen",sequenceName = "student_seq",initialValue = 100)
	private Integer studentId;
	@Column(length = 20)
	private String department;
	// save the child reference address before saving student object
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "add_id") // to give a different column name
	private Address address;
}