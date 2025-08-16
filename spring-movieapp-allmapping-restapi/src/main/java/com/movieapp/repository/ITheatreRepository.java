package com.movieapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.movieapp.model.Theatre;
import com.movieapp.model.TheatreProjection;
@Repository
public interface ITheatreRepository extends JpaRepository<Theatre, Integer>{
	
	@Query("select t from Theatre t inner join t.movies m where m.movieTitle = ?1")
	List<TheatreProjection> findByMovies(String movieTitle);

}
