package com.movieapp.controllers;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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


import com.movieapp.exception.TheatreNotFoundException;

import com.movieapp.model.TheatreDto;
import com.movieapp.model.TheatreProjection;
import com.movieapp.service.ITheatreService;

@RestController
@RequestMapping("/movies-api/v1")
public class TheatreController {
	@Autowired
	private ITheatreService theatreService;
	
	

	
	//http://localhost:8081/movies-api/v1/admin/movies/theatre
	@PostMapping("/admin/movies/theatre")
	ResponseEntity<Void> addTheatre(@RequestBody TheatreDto theatreDto) {
		theatreService.addTheatre(theatreDto);
		HttpHeaders headers=new HttpHeaders();
		headers.add("info", "Theatre Inserted");
		return ResponseEntity.status(HttpStatus.CREATED).headers(headers).build();

	}
	
	//http://localhost:8081/movies-api/v1/admin/movies/theatre
	@PutMapping("/admin/movies/theatre")
	ResponseEntity<Void> updateTheatre(@RequestBody TheatreDto theatreDto) {
		theatreService.updateTheatre(theatreDto);
		HttpHeaders headers=new HttpHeaders();
		headers.add("info", "Theatre updated by Id");
		return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).build();
		
	}
	
	
	
	//http://localhost:8081/movies-api/v1/admin/movies/theatre/theatreId/2
	@DeleteMapping("/admin/movies/theatre/theatreId/{theatreId}")
	ResponseEntity<Void> deleteTheatre(@PathVariable int theatreId){
		theatreService.deleteTheatre(theatreId);
		HttpHeaders headers=new HttpHeaders();
		headers.add("info", "Theatre deleted by id");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).build();
		
	}
	
	
	//http://localhost:8081/movies-api/v1/movies/theatre/theatreId?theatreId=1
	@GetMapping("/movies/theatre/theatreId")
	ResponseEntity<TheatreDto> getByTheatreId(@RequestParam int theatreId) throws TheatreNotFoundException{
		TheatreDto theatreDto=theatreService.getByTheatreId(theatreId);
		HttpHeaders headers=new HttpHeaders();
		headers.add("info", "Getting Theatre by id");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(theatreDto);
	}
	
	//http://localhost:8081/movies-api/v1/movies/theatre/movieTitle/3BHK
		@GetMapping("/movies/theatre/movieTitle/{movieTitle}")
		ResponseEntity<List<TheatreProjection>> getByMovies(@PathVariable String movieTitle) throws TheatreNotFoundException{
			List<TheatreProjection> theatreDto=theatreService.getByMovies(movieTitle);
			HttpHeaders headers=new HttpHeaders();
			headers.add("info", "Getting Theatre by movie");
			return ResponseEntity.status(HttpStatus.OK).headers(headers).body(theatreDto);
		}

	
	
}
