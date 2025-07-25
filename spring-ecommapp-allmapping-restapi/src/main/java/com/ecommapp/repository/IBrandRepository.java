package com.ecommapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommapp.model.Brand;
@Repository
public interface IBrandRepository extends JpaRepository<Brand, Integer>{

}
