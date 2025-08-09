package com.movieapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movieapp.model.Director;
import com.movieapp.model.Theatre;
@Repository
public interface ITheatreRepository extends JpaRepository<Theatre, Integer>{

	

}
