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

public class TheatreDto {
	
	private Integer theatreId;
	private String theatreName;
	private String ticketType; //mticket or eticket
	private String theatreInfo;	
	private List<ShowTimeDto> showTimes;	
	@ToString.Exclude
	@JsonIgnore
	private List<Movie> movies;
	public TheatreDto(String theatreName, String ticketType, String theatreInfo, List<ShowTimeDto> showTimes) {
		super();
		this.theatreName = theatreName;
		this.ticketType = ticketType;
		this.theatreInfo = theatreInfo;
		this.showTimes = showTimes;
	}
	
	
}
