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

public class DirectorDto {
	
	private Integer directorId;
	private String directorName;
	private String directorInfo;
	
	@ToString.Exclude
	@JsonIgnore
	private List<Movie> movies;

	public DirectorDto(String directorName, String directorInfo) {
		super();
		this.directorName = directorName;
		this.directorInfo = directorInfo;
	}
}
