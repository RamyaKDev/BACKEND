package com.movieapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.movieapp.exception.MovieNotFoundException;
import com.movieapp.model.MovieDto;
import com.movieapp.model.MovieTitleDto;
import com.movieapp.service.IMovieService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Movie Controller", description ="has rest end points of movie")
@RequestMapping("/movies-api/v1")
//to access swagger
//http://localhost:8081/swagger-ui/index.html
public class MovieController {
	@Autowired
	private IMovieService movieService;
	
	
	//http://localhost:8081/movies-api/v1/movies
	@Operation(operationId = "createMovie",
			   summary = "Adding a Movie",
			   description = "This restend point is used to create a movie")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "201",
					     description="creates a new movie",
					     content = @Content(
					    		       mediaType = "application/json",
					    		       schema = @Schema(implementation = MovieDto.class)) )
	})

	@PostMapping("/movies")
	ResponseEntity<Void> addMovie(@RequestBody MovieDto movieDto) {
		movieService.addMovie(movieDto);
		HttpHeaders headers=new HttpHeaders();
		headers.add("info", "Movie Inserted");
		return ResponseEntity.status(HttpStatus.CREATED).headers(headers).build();

	}
	
	//http://localhost:8081/movies-api/v1/movies
	@Operation(operationId = "UpdateMovie",
			   summary = "Updating movie details",
			   description = "This restend point is used to update a movie")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "202",
					     description="updates a movie",
					     content = @Content(
					    		       mediaType = "application/json",
					    		       schema = @Schema(implementation = MovieDto.class)) )
	})

	@PutMapping("/movies")
	ResponseEntity<Void> updateMovie(@RequestBody MovieDto movieDto) {
		movieService.updateMovie(movieDto);
		HttpHeaders headers=new HttpHeaders();
		headers.add("info", "Movie updated by Id");
		return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).build();
		
	}
	
	//http://localhost:8081/movies-api/v1/movies/newTitle
	
	@Operation(operationId = "Update MovieTitle",
	   summary = "Updating few resources in movie ",
	   description = "This restend point is used to update a few resources in movie")
@ApiResponses(value = {
	@ApiResponse(responseCode = "202",
			     description="updates a movie",
			     content = @Content(
			    		       mediaType = "application/json",
			    		       schema = @Schema(implementation = MovieDto.class)) )
})
	@PatchMapping("/movies/newTitle")
	ResponseEntity<Void> updateMovie(@RequestBody MovieTitleDto movietitleDto) {
		int movieId=movietitleDto.getMovieId();
		String newmovie=movietitleDto.getMovieTitle();
		
		movieService.updateMovieTitle(movieId, newmovie);	
		HttpHeaders headers=new HttpHeaders();
		headers.add("info", "Movie updated by Id");
		return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).build();
		
		}
	
	//http://localhost:8081/movies-api/v1/movies/movieId/2
	@Operation(operationId = "Delete Movie",
			   summary = "Delete movie by Id",
			   description = "This restend point is used to delete a movie by id",
				parameters = {
			   @Parameter(name = "movieId",
					      required = true,
					      description = "pass movieId")
	   			}
	)
		@ApiResponses(value = {
			@ApiResponse(responseCode = "200",
					     description="delete a movie by id",
					     content = @Content(
					    		       mediaType = "application/json",
					    		       schema = @Schema(implementation = MovieDto.class)) )
		})
	@DeleteMapping("/movies/movieId/{movieId}")
	ResponseEntity<Void> deleteMovie(@PathVariable int movieId){
		movieService.deleteMovie(movieId);
		HttpHeaders headers=new HttpHeaders();
		headers.add("info", "Movie deleted by id");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).build();
		
	}
	//http://localhost:8081/movies-api/v1/movies
	@Operation(operationId = "getAllmovies",
			   summary = "Getting list of movies",
			   description = "This rest end point is used to return a list of movies")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200",
					     description=" returns a list of movies",
					     content = @Content(
					    		       mediaType = "application/json",
					    		       schema = @Schema(implementation = MovieDto.class)) )
	})

	@GetMapping("/movies")
	ResponseEntity<List<MovieDto>> getAll(){
		List<MovieDto> movieDto=movieService.getAll();
		HttpHeaders headers=new HttpHeaders();
		headers.add("info", "Getting all movies");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(movieDto);
		
		
	}
	
	//http://localhost:8081/movies-api/v1/movies/movieId?movieId=1
	 @Operation(operationId = "getMovieById",
			   summary = "Getting one movie by Id",
			   description = "This restend point is used return a movie by id",
			   parameters = {
					   @Parameter(name = "movieId",
							      required = true,
							      description = "pass movieId")
			   }
			)
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200",
					     description="returns one movie",
					     content = @Content(
					    		       mediaType = "application/json",
					    		       schema = @Schema(implementation = MovieDto.class)) )
	})

	@GetMapping("/movies/movieId")
	ResponseEntity<MovieDto> getByMovieId(@RequestParam int movieId) throws MovieNotFoundException{
		MovieDto movieDto=movieService.getByMovieId(movieId);
		HttpHeaders headers=new HttpHeaders();
		headers.add("info", "Getting movie by id");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(movieDto);
	}


	
	//http://localhost:8081/movies-api/v1/movies/director/James
	 @Operation(operationId = "getMovieBydirector",
			   summary = "Getting movies by director",
			   description = "This restend point is used return a movie by director",
			   parameters = {
					   @Parameter(name = "director",
							      required = true,
							      description = "pass director")
			   }
			)
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200",
					     description="returns list of movies",
					     content = @Content(
					    		       mediaType = "application/json",
					    		       schema = @Schema(implementation = MovieDto.class)) )
	})
	@GetMapping("/movies/director/{director}")
	ResponseEntity<List<MovieDto>> getByDirector(@PathVariable("director") String directorName) throws MovieNotFoundException{
		List<MovieDto> movieDto=movieService.getByDirector(directorName);
		HttpHeaders headers=new HttpHeaders();
		headers.add("info", "Getting movie by director");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(movieDto);
		
	}
	
	//http://localhost:8081/movies-api/v1/movies/theatreName/Mayajaal/movieTitle/3BHK
	 @Operation(operationId = "getMovie By theatreName and movieTitle",
			   summary = "Getting list of movies by theatreName and movieTitle",
			   description = "This restend point is used return a movie by theatreName and movieTitle",
			   parameters = {
					   @Parameter(name = "theatreName",
							      required = true,
							      description = "pass theatreName"),
					   @Parameter(name = "movieTitle",
					      required = true,
					      description = "pass movieTitle")
			   }
	 
	 
			)
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200",
					     description="returns list of movies",
					     content = @Content(
					    		       mediaType = "application/json",
					    		       schema = @Schema(implementation = MovieDto.class)) )
	})
		@GetMapping("/movies/theatreName/{theatreName}/movieTitle/{movieTitle}")
	ResponseEntity<List<MovieDto>> getByTheatreandmovie(@PathVariable String theatreName,@PathVariable String movieTitle) throws MovieNotFoundException{
			List<MovieDto> movieDto=movieService.getByTheatreandmovie(theatreName, movieTitle);
			HttpHeaders headers=new HttpHeaders();
			headers.add("info", "Getting movie by theatreName and movieTitle");
			return ResponseEntity.status(HttpStatus.OK).headers(headers).body(movieDto);
		
	}
		
}
