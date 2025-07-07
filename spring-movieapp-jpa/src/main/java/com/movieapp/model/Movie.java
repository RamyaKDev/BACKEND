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
public class Movie {
	private String title;
	@Id
	@GeneratedValue(generator="movie_gen",strategy = GenerationType.AUTO)
	@SequenceGenerator(name="movie_gen",sequenceName = "movie_seq",initialValue = 100)
	private Integer movieId;
	private int releaseYear;
	private String language;
	private String genre;
	private String format;
	private String director; 
}
