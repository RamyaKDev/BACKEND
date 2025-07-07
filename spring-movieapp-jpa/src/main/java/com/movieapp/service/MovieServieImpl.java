package com.movieapp.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movieapp.exception.MovieNotFoundException;
import com.movieapp.model.Movie;
import com.movieapp.model.MovieDto;
import com.movieapp.repository.IMovieRepository;
@Service
public class MovieServieImpl implements IMovieService {
	@Autowired
	private ModelMapper mapper;
	
	private IMovieRepository movieRepository;
	
	public MovieServieImpl(IMovieRepository movieRepository) {
		super();
		this.movieRepository = movieRepository;
	}

	@Override
	public void addMovie(MovieDto movieDto) {
		Movie movie=mapper.map(movieDto,Movie.class);
		movieRepository.save(movie);
		
	}

	@Override
	public void updateMovie(MovieDto movieDto) {
		Movie movie=mapper.map(movieDto,Movie.class);
		movieRepository.save(movie);
		
	}

	@Override
	public void deleteMovie(int movieId) {
		movieRepository.deleteById(movieId);
		
	}

	@Override
	public List<MovieDto> getAll() {
		List<Movie> movies=movieRepository.findAll();
		return movies.stream()
				.map((movie)->mapper.map(movie, MovieDto.class))
				.toList();
	}

	@Override
	public MovieDto getByMovieId(int movieId) {
		Movie movie=movieRepository.findById(movieId)
				.orElseThrow(()->new MovieNotFoundException("invalid id"));			
		MovieDto movieDto=mapper.map(movie,MovieDto.class);
		return movieDto;
	}

	@Override
	public List<MovieDto> getByLanguage(String language) {

		List<Movie> movies = movieRepository.findByLanguage(language);
		if (movies.isEmpty())
			throw new MovieNotFoundException("No movie found in the specified language");
		return movies.stream().map((movie) -> mapper.map(movie, MovieDto.class))
				.toList();

	}
	@Override
	public List<MovieDto> getByDirector(String director) {
		List<Movie> movies=movieRepository.findByDirector(director);
		if(movies.isEmpty())
			throw new MovieNotFoundException("No movie found in the specified director");
		return movies.stream()
		.map((movie)->mapper.map(movie, MovieDto.class))
		.toList();
	}

	@Override
	public List<MovieDto> getByRelAndLang(int releaseYear, String language) {
		List<Movie> movies=movieRepository.findByRelAndLang(releaseYear, language);
		if(movies.isEmpty())
			throw new MovieNotFoundException("No movie found in the specified release and language");
		return movies.stream()
		.map((movie)->mapper.map(movie, MovieDto.class))
		.toList();
	}

	@Override
	public List<MovieDto> getByGenAndLang(String genre, String language) {
		List<Movie> movies=movieRepository.findByGenAndLang(genre, language);
		if(movies.isEmpty())
			throw new MovieNotFoundException("No movie found in the specified genre and language");
		return movies.stream()
		.map((movie)->mapper.map(movie, MovieDto.class))
		.toList();
	}

	@Override
	public List<MovieDto> getByGenAndFormat(String genre, String format) {
		List<Movie> movies=movieRepository.findByGenAndFormat(genre, format);
		if(movies.isEmpty())
			throw new MovieNotFoundException("No movie found in the specified genre and format");
		return movies.stream()
		.map((movie)->mapper.map(movie, MovieDto.class))
		.toList();
	}

	
}
