package com.movieapp.service;

import com.movieapp.exception.DirectorNotFoundException;
import com.movieapp.model.DirectorDto;

public interface IDirectorService {
	//CRUD Operations
		void addDirector(DirectorDto directorDto);
		void updateDirector(DirectorDto  directorDto);
		void deleteDirector(int directorId);		
		DirectorDto getByDirectorId(int  directorId) throws DirectorNotFoundException;
		
	
		
}
