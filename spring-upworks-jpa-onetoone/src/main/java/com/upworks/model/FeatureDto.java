package com.upworks.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class FeatureDto {
	private Integer featureId;
	private String mode;// online, offline
	private String jobType;// parttime,fulltime
	private String description;
	private String role;// contract,permanent
}
