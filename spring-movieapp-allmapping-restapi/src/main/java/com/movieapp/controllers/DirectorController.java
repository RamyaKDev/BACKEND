package com.movieapp.controllers;



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


import com.movieapp.exception.DirectorNotFoundException;

import com.movieapp.model.DirectorDto;
import com.movieapp.service.IDirectorService;

@RestController
@RequestMapping("/movies-api/v1")
public class DirectorController {
	@Autowired
	private IDirectorService directorService;
	
	

	
	//http://localhost:8081/movies-api/v1/admin/movies/director
	@PostMapping("/admin/movies/director")
	ResponseEntity<Void> addDirector(@RequestBody DirectorDto directorDto) {
		directorService.addDirector(directorDto);
		HttpHeaders headers=new HttpHeaders();
		headers.add("info", "Director Inserted");
		return ResponseEntity.status(HttpStatus.CREATED).headers(headers).build();

	}
	
	//http://localhost:8081/movies-api/v1/admin/movies/director
	@PutMapping("/admin/movies/director")
	ResponseEntity<Void> updateDirector(@RequestBody DirectorDto directorDto) {
		directorService.updateDirector(directorDto);
		HttpHeaders headers=new HttpHeaders();
		headers.add("info", "Director updated by Id");
		return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).build();
		
	}
	
	
	
	//http://localhost:8081/movies-api/v1/admin/movies/director/directorId/2
	@DeleteMapping("/admin/movies/director/directorId/{directorId}")
	ResponseEntity<Void> deleteDirector(@PathVariable int directorId){
		directorService.deleteDirector(directorId);
		HttpHeaders headers=new HttpHeaders();
		headers.add("info", "Director deleted by id");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).build();
		
	}
	
	
	//http://localhost:8081/movies-api/v1/movies/director/directorId?directorId=1
	@GetMapping("/movies/director/directorId")
	ResponseEntity<DirectorDto> getByDirectorId(@RequestParam int directorId) throws DirectorNotFoundException{
		DirectorDto directorDto=directorService.getByDirectorId(directorId);
		HttpHeaders headers=new HttpHeaders();
		headers.add("info", "Getting Director by id");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(directorDto);
	}


	
	
}
