package com.ecommapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommapp.model.Category;
@Repository
public interface ICategoryRepository extends JpaRepository<Category, Integer>{

}
