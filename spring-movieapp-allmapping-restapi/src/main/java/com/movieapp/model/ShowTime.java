package com.movieapp.model;

import java.time.LocalDateTime;

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
public class ShowTime {
	@Id
	@GeneratedValue(generator="showtime_gen",strategy = GenerationType.AUTO)
	@SequenceGenerator(name="showtime_gen",sequenceName = "showtime_seq",initialValue = 1,allocationSize = 251)
	private Integer showtimeId;
	private String time;
}
