package com.upwork.model;


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

public class FeaturesDto {
	
	private Integer featuresId;
	private String mode;// online, offline
	private String jobType;// parttime,fulltime	
	private String description;
	private String role;// contract,permananet

}
