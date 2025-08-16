package com.movieapp.service;

import java.util.List;

import com.movieapp.exception.TheatreNotFoundException;
import com.movieapp.model.TheatreDto;
import com.movieapp.model.TheatreProjection;

public interface ITheatreService {
	//CRUD Operations
		void addTheatre(TheatreDto theatreDto);
		void updateTheatre(TheatreDto theatreDto);
		void deleteTheatre(int theatreId);		
		TheatreDto getByTheatreId(int theatreId) throws TheatreNotFoundException;
		List<TheatreProjection> getByMovies(String movieTitle);
	
}
