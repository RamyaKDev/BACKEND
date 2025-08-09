package com.movieapp.service;

import com.movieapp.exception.TheatreNotFoundException;
import com.movieapp.model.TheatreDto;

public interface ITheatreService {
	//CRUD Operations
		void addTheatre(TheatreDto theatreDto);
		void updateTheatre(TheatreDto theatreDto);
		void deleteTheatre(int theatreId);		
		TheatreDto getByTheatreId(int theatreId) throws TheatreNotFoundException;
		
	
}
