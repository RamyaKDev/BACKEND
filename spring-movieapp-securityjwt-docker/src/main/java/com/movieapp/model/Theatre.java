package com.movieapp.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
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
public class Theatre {
	@Id
	@GeneratedValue(generator="theatre_gen",strategy = GenerationType.AUTO)
	@SequenceGenerator(name="theatre_gen",sequenceName = "theatre_seq",initialValue = 201,allocationSize = 201)
	private Integer theatreId;
	private String theatreName;
	private String ticketType; //mticket or eticket
	private String theatreInfo;
	
	//One Theatre has many showtimes
	@OneToMany(cascade=CascadeType.ALL,fetch = FetchType.EAGER)
	//Add Theatre id in many side
	@JoinColumn(name="theatre_Id")
	private List<ShowTime> showTimes;
	
	@ManyToMany(mappedBy = "theaters")
	@ToString.Exclude
	@JsonIgnore
	private List<Movie> movies;
	
	
}
