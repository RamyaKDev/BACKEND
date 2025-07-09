package com.restaurantapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.restaurantapp.model.Restaurant;




@Repository
public interface IRestaurantRepository extends JpaRepository<Restaurant, Integer>{
	//Derived Query
	List<Restaurant> findByCuisine(String cuisine);
	List<Restaurant> findByCategory(String category);
	
	
	
	//custom query
		@Query("from Restaurant r inner join r.items it where r.cuisine = ?1 and it.itemType=?2")
		List<Restaurant> findByCuisineItemType(String cuisine,String itemType);
		
		@Query("from Restaurant r inner join r.items it where r.category = ?1 and it.itemName like ?2")
		List<Restaurant> findByCategoryItemName(String category,String itemName);
		
		@Query("from Restaurant r inner join r.items it where it.itemName like ?1")
		List<Restaurant> findByItemName(String itemName);

}
