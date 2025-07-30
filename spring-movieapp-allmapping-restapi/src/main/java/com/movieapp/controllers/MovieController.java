package com.movieapp.controllers;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.movieapp.exception.MovieNotFoundException;
import com.movieapp.model.MovieDto;
import com.movieapp.service.IMovieService;

@RestController
@RequestMapping("/movies-api/v1")
public class MovieController {
	private IMovieService movieService;
	
	//https://localhost:8081/movies-api/v1/movies
	@PostMapping("/movies")
	ResponseEntity<Void> addMovie(@RequestBody MovieDto movieDto) {
		movieService.addMovie(movieDto);
		HttpHeaders headers=new HttpHeaders();
		headers.add("info", "Movie Inserted");
		return ResponseEntity.status(HttpStatus.CREATED).headers(headers).build();

	}
	
	//https://localhost:8081/movies-api/v1/movies
	@PutMapping("/movies")
	ResponseEntity<Void> updateMovie(@RequestBody MovieDto movieDto) {
		movieService.addMovie(movieDto);
		HttpHeaders headers=new HttpHeaders();
		headers.add("info", "Movie updated by Id");
		return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).build();
		
	}
	
	//https://localhost:8081/movies-api/v1/movies/movieId/2
	@DeleteMapping("/movies/movieId/{movieId}")
	ResponseEntity<Void> deleteMovie(@PathVariable int movieId){
		movieService.deleteMovie(movieId);
		HttpHeaders headers=new HttpHeaders();
		headers.add("info", "Movie deleted by id");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).build();
		
	}
	//https://localhost:8081/movies-api/v1/movies
	@GetMapping("/movies")
	ResponseEntity<List<MovieDto>> getAll(){
		List<MovieDto> movieDto=movieService.getAll();
		HttpHeaders headers=new HttpHeaders();
		headers.add("info", "Getting all movies");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(movieDto);
		
		
	}
	
	//https://localhost:8081/movies-api/v1/movies/movieId?movieId=1
	@GetMapping("/movies/movieId")
	ResponseEntity<MovieDto> getByMovieId(@RequestParam int movieId) throws MovieNotFoundException{
		MovieDto movieDto=movieService.getByMovieId(movieId);
		HttpHeaders headers=new HttpHeaders();
		headers.add("info", "Getting movie by id");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(movieDto);
	}

	//https://localhost:8081/movies-api/v1/movies/language?=Tamil
	@GetMapping("/movies/language")
	ResponseEntity<List<MovieDto>> getByLanguage(@RequestParam String language) throws MovieNotFoundException{
			List<MovieDto> movieDto=movieService.getByLanguage(language);
			HttpHeaders headers=new HttpHeaders();
			headers.add("info", "Getting movie by language");
			return ResponseEntity.status(HttpStatus.OK).headers(headers).body(movieDto);
		
	}
	
	//https://localhost:8081/movies-api/v1/movies/director/James
	@GetMapping("/movies/director/{director}")
	ResponseEntity<List<MovieDto>> getByDirector(@PathVariable("director") String directorName) throws MovieNotFoundException{
		List<MovieDto> movieDto=movieService.getByDirector(directorName);
		HttpHeaders headers=new HttpHeaders();
		headers.add("info", "Getting movie by director");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(movieDto);
		
	}
	
	//https://localhost:8081/movies-api/v1/movies/theatreName/James/movieTitle/Superman
		@GetMapping("/movies/theatreName/{theatreName}/movieTitle/{movieTitle}")
	ResponseEntity<List<MovieDto>> getByTheatreandmovie(@PathVariable String theatreName,@PathVariable String movieTitle) throws MovieNotFoundException{
			List<MovieDto> movieDto=movieService.getByTheatreandmovie(theatreName, movieTitle);
			HttpHeaders headers=new HttpHeaders();
			headers.add("info", "Getting movie by theatreName and movieTitle");
			return ResponseEntity.status(HttpStatus.OK).headers(headers).body(movieDto);
		
	}
}
