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
public class Review {
	@Id
	@GeneratedValue(generator="review_gen",strategy = GenerationType.AUTO)
	@SequenceGenerator(name="review_gen",sequenceName = "review_seq",initialValue = 1,allocationSize = 101)
	private Integer reviewId;
	private String reviewerName;
	private String title;
	private String reviewdetails;
	private int rating;
}
