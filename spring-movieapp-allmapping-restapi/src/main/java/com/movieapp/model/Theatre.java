package com.movieapp.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Theatre {
	@Id
	@GeneratedValue(generator="theatre_gen",strategy = GenerationType.AUTO)
	@SequenceGenerator(name="theatre_gen",sequenceName = "theatre_seq",initialValue = 1,allocationSize = 201)
	private Integer theatreId;
	private String theatreName;
	private String ticketType; //mticket or eticket
	
	@ManyToMany(mappedBy = "theaters")
	@ToString.Exclude
	private List<Movie> movies;
	
	
}
