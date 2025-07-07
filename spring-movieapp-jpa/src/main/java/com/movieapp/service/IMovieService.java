package com.movieapp.service;

import java.util.List;

import com.movieapp.model.Movie;
import com.movieapp.model.MovieDto;

public interface IMovieService {
//CRUD Operations
	void addMovie(MovieDto movieDto);
	void updateMovie(MovieDto movieDto);
	void deleteMovie(int movieId);
	List<MovieDto> getAll();
	MovieDto getByMovieId(int movieId);
	
//Custom methods	
	List<MovieDto> getByLanguage(String language); 
	List<MovieDto> getByDirector(String director); 
	List<MovieDto> getByRelAndLang(int releaseYear, String language);
	List<MovieDto> getByGenAndLang(String genre ,String language);
	List<MovieDto> getByGenAndFormat(String genre, String format);
	
	
}
