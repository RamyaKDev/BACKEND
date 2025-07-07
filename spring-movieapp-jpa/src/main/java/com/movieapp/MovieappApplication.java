package com.movieapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.movieapp.model.MovieDto;
import com.movieapp.service.IMovieService;

@SpringBootApplication
public class MovieappApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(MovieappApplication.class, args);
	}
	@Autowired
	private IMovieService movieService;
	@Override
	public void run(String... args) throws Exception {
		// create movie object
		MovieDto movieDto=new MovieDto("Bhagubali-1",null,2015,"Tamil","History","2D","Rajamougli");
		movieService.addMovie(movieDto);
		movieDto=new MovieDto("SpyKids",null,2023,"English","Fantasy","2D","Robert Rodriguez");
		movieService.addMovie(movieDto);
		movieDto=new MovieDto("Bhagubali-2",null,2019,"Tamil","History","2D","Rajamougli");
		movieService.addMovie(movieDto);
		movieDto=new MovieDto("3BHK",null,2025,"Telugu","Family","2D","Sri Ganesh");
		movieService.addMovie(movieDto);
		movieDto=new MovieDto("JungleBook",null,2016,"English","Cartoon","3D","Jon Favreau");
		movieService.addMovie(movieDto);
		
		System.out.println();
		System.out.println("Get Movie by Id");
		MovieDto nmovieDto=movieService.getByMovieId(100);
		System.out.println(nmovieDto);
		
		System.out.println();
		System.out.println("Update Movie by Id");
		nmovieDto.setLanguage("Telugu");
		movieService.updateMovie(nmovieDto);
		System.out.println(nmovieDto);
		
		System.out.println();
		System.out.println("Get All Movies ");
		movieService.getAll().forEach(System.out::println);
		
		System.out.println();
		System.out.println("Get Movie by Language");
		movieService.getByLanguage("English").forEach(System.out::println);
		
		System.out.println();
		System.out.println("Get Movie by Director");
		movieService.getByDirector("Rajamougli").forEach(System.out::println);
		
		System.out.println();
		System.out.println("Delete Movie by Id");
		//movieService.deleteMovie(123);
		
		System.out.println();
		System.out.println("Get Movie by release year and Language");
		movieService.getByRelAndLang(2023, "English").forEach(System.out::println);
		
		System.out.println();
		System.out.println("Get Movie by genre and format");
		movieService.getByGenAndFormat("History", "2D").forEach(System.out::println);
		
		System.out.println();
		System.out.println("Get Movie by genre and Language");
	    movieService.getByGenAndLang("Cartoon", "English").forEach(System.out::println);
	}

}
