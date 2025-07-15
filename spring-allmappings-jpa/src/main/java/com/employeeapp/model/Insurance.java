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

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Insurance {
	@Column(length = 20)
	private String insuranceName;
	@Id
	@GeneratedValue(generator ="insurance_gen", strategy = GenerationType.AUTO )
	@SequenceGenerator(name = "insurance_gen",sequenceName = "insurance_seq", initialValue = 11)
	private Integer insuranceId;
	private String brand;
	private String type;//health,vehicle,house
	private double premium;
}
