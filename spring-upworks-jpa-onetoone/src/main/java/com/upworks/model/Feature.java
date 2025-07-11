package com.upworks.model;

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
public class Feature {
	@Id
	@GeneratedValue(generator = "feature_gen", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "feature_gen", sequenceName = "feature_seq", initialValue = 51)
	private Integer featureId;
	private String mode;// online, offline
	private String jobType;// parttime,fulltime
	@Column(length = 50)
	private String description;
	private String role;// contract,permananet

}
