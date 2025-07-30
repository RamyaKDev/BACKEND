package com.movieapp;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.movieapp.model.DirectorDto;
import com.movieapp.model.ShowTimeDto;
import com.movieapp.model.TheatreDto;
import com.movieapp.service.IDirectorService;
import com.movieapp.service.ITheatreService;

@SpringBootApplication
public class SpringMovieappAllmappingRestapiApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringMovieappAllmappingRestapiApplication.class, args);
	}
	@Autowired
	private IDirectorService directorService;
	
	@Autowired
	private ITheatreService TheatreService;
	@Override 
	public void run(String... args) throws Exception {
		DirectorDto directorDto=new DirectorDto("Sri Ganesh","He is a director as well as Writer");
		directorService.addDirector(directorDto);
		
		directorDto=new DirectorDto("James","Co-CEO of DC Studios");
		directorService.addDirector(directorDto);
		
		directorDto=new DirectorDto("Raamkiran","Assistant director of 3BHK movie");
		directorService.addDirector(directorDto);
		
		directorDto=new DirectorDto("Henry Cavil","\"Assistant director of Superman movie");
		directorService.addDirector(directorDto);
		
		ShowTimeDto showTimeDto1= new ShowTimeDto(null,"6:45 pm");
		ShowTimeDto showTimeDto2= new ShowTimeDto(null,"9:15 am");
		ShowTimeDto showTimeDto3= new ShowTimeDto(null,"1:45 pm");
		List<ShowTimeDto> showTimes= new ArrayList<ShowTimeDto>(Arrays.asList(showTimeDto1,showTimeDto2,showTimeDto3));
		TheatreDto theatreDto=new TheatreDto("Mayajaal","eticket","Mulitiplex",showTimes);
		TheatreService.addTheatre(theatreDto);
		
		 showTimeDto1= new ShowTimeDto(null,"8:45 pm");
		 showTimeDto2= new ShowTimeDto(null,"7:15 am");
		 showTimeDto3= new ShowTimeDto(null,"9:45 pm");
		List<ShowTimeDto> showTimes1= new ArrayList<ShowTimeDto>(Arrays.asList(showTimeDto1,showTimeDto2,showTimeDto3));
		TheatreDto theatreDto1=new TheatreDto("PVR","eticket","Luxury",showTimes1);
		TheatreService.addTheatre(theatreDto1);
		
		 showTimeDto1= new ShowTimeDto(null,"8:45 am");
		 showTimeDto2= new ShowTimeDto(null,"7:15 pm");
		 showTimeDto3= new ShowTimeDto(null,"2:00 pm");
		List<ShowTimeDto> showTimes2= new ArrayList<ShowTimeDto>(Arrays.asList(showTimeDto1,showTimeDto2,showTimeDto3));
		TheatreDto theatreDto2=new TheatreDto("PVR","eticket","Luxury",showTimes2);
		TheatreService.addTheatre(theatreDto2);
		
		
	}

}
