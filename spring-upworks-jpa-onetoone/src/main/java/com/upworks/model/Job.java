package com.upworks.model;

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
public class Job {
	@Column(length = 30)
	private String jobTitle;
	@Id
	@GeneratedValue(generator = "job_gen", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "job_gen", sequenceName = "job_seq", initialValue = 101)
	private Integer jobId;
	private double rate;
	@Column(length = 20)
	private String location;
	// save the child reference address before saving student object
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fea_id") // to give a different column name
	private Feature feature;
}
