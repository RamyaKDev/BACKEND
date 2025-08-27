package com.movieapp.model;

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
public class Features {
	@Id
	@GeneratedValue(generator="features_gen",strategy = GenerationType.AUTO)
	@SequenceGenerator(name="features_gen",sequenceName = "features_seq",initialValue = 51,allocationSize = 51)
	private Integer featuresId;
	private int rating;
	private String movieInfo;
	private String duration;
	private String category; //UA,A,U
}

