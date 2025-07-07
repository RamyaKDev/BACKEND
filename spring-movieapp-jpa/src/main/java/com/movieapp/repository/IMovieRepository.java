package com.movieapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.movieapp.model.Movie;
import com.movieapp.model.MovieDto;
@Repository
public interface IMovieRepository extends JpaRepository<Movie, Integer>{
	//Derived Query
	List<Movie> findByLanguage(String language); 
	List<Movie> findByDirector(String director);
	
	//Custom Query
	@Query("from Movie m where m.releaseYear=?1 and m.language = ?2")
	List<Movie> findByRelAndLang(int releaseYear, String language);
	
	@Query("from Movie m where m.genre=?1 and m.language = ?2")
	List<Movie> findByGenAndLang(String genre ,String language);
	
	@Query("from Movie m where m.genre=?1 and m.format = ?2")
	List<Movie> findByGenAndFormat(String genre, String format);
	
}
