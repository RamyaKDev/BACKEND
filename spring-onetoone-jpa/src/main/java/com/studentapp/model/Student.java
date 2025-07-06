package com.studentapp.model;

import org.hibernate.annotations.Cascade;
import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails.Address;

import jakarta.persistence.CascadeType;
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
	private String studentName;
	@Id
	@GeneratedValue(generator = "stud_gen", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "stu_gen", sequenceName = "student_seq", initialValue = 100)
	private int studentId;
	private String department;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="add_id")
	
	private Address address;

}
