package com.movieapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movieapp.model.Director;
@Repository
public interface IDirectorRepository extends JpaRepository<Director, Integer>{

}
