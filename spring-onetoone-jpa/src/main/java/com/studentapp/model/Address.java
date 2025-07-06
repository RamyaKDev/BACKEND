package com.studentapp.model;

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
public class Address {
	@Column(length = 20)
	private String city;
	@Id
	@GeneratedValue(generator ="address_gen", strategy = GenerationType.AUTO )
	@SequenceGenerator(name = "address_gen",sequenceName = "address_seq", initialValue = 1)
	private Integer addressId;
	private String state;
}