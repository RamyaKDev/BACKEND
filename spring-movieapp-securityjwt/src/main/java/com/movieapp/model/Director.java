package com.movieapp.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Director {
	@Id
	@GeneratedValue(generator="director_gen",strategy = GenerationType.AUTO)
	@SequenceGenerator(name="director_gen",sequenceName = "director_seq",initialValue = 151,allocationSize = 151)
	private Integer directorId;
	private String directorName;
	private String directorInfo;
	
	@OneToMany(mappedBy = "director")
	@ToString.Exclude
	@JsonIgnore
	private List<Movie> movies;
}
