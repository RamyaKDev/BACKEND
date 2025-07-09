package com.restaurantapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restaurantapp.model.Restaurant;

@Repository
public interface IRestaurantRepository extends JpaRepository<Restaurant, Integer>{

}
