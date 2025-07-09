package com.restaurantapp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.restaurantapp.model.CATEGORY;
import com.restaurantapp.model.CUISINE;
import com.restaurantapp.model.ITEMTYPE;
import com.restaurantapp.model.Item;
import com.restaurantapp.model.ItemDto;
import com.restaurantapp.model.RestaurantDto;
import com.restaurantapp.service.IRestaurantService;

@SpringBootApplication
public class SpringOnetomanyJpaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringOnetomanyJpaApplication.class, args);
	}

	@Autowired
	private IRestaurantService restaurantService;

	@Override
	public void run(String... args) throws Exception {
		//Save item table first
		ItemDto item1 = new ItemDto("Masala Dosa", null, ITEMTYPE.BREAKFAST.name(), 270);
		ItemDto item2 = new ItemDto("Mysore Park", null, ITEMTYPE.DESSERT.name(), 120);
		ItemDto item3 = new ItemDto("Mushroom Soup", null, ITEMTYPE.SOUPS.name(), 320);
		// Here hashset accepts collection so we are passing as a list.
		Set<ItemDto> itemDtos = new HashSet<ItemDto>(Arrays.asList(item1, item2, item3));
		
		//save restaurant table after item table
		RestaurantDto restaurantDto = new RestaurantDto("Sangeetha", null, CATEGORY.VEG.name(),
				CUISINE.IT.getCuisineType(), "Kerala", itemDtos);
		
		//add restaurant
		restaurantService.addRestaurant(restaurantDto);
		
		//Save item table first
		item1 = new ItemDto("Mutton Briyani", null, ITEMTYPE.MAINCOURSE.name(), 780);
		item2 = new ItemDto("Vanilla Ice Cream", null, ITEMTYPE.DESSERT.name(), 150);
		item3 = new ItemDto("Chicken Salad", null, ITEMTYPE.SALADS.name(), 150);
		// Here hashset accepts collection so we are passing as a list.
		itemDtos = new HashSet<ItemDto>(Arrays.asList(item1, item2, item3));
		
		//save restaurant table after item table
		 restaurantDto = new RestaurantDto("Udupi", null, CATEGORY.NONVEG.name(),
				CUISINE.NI.getCuisineType(), "Bangalore", itemDtos);
		 
		//add restaurant
		restaurantService.addRestaurant(restaurantDto);
		System.out.println();
		System.out.println("delete Restaurant by Id");
		//restaurantService.deleteRestaurant(51);
		
		System.out.println();
		System.out.println("Get Restaurant by Id");
		RestaurantDto nrestaurantDto=restaurantService.getById(50);		
		System.out.println(nrestaurantDto);
		
		System.out.println();
		System.out.println("Update Restaurant by Id");
		nrestaurantDto.setCity("Mumbai");
		restaurantService.updateRestaurant(nrestaurantDto) ;
		
		System.out.println();
		System.out.println("Get All");
		restaurantService.getAll().forEach(System.out::println);
		
		System.out.println();
		System.out.println("Get By Cuisine");
		restaurantService.getByCuisine(CUISINE.SI.getCuisineType()).forEach(System.out::println);
		
		
		System.out.println();
		System.out.println("Get By Category");
		restaurantService.getByCategory(CATEGORY.NONVEG.name()).forEach(System.out::println);
		
		System.out.println();
		System.out.println("Get By Category and itemname");
		restaurantService.getByCategoryItemName(CATEGORY.VEG.name(),"Dosa").forEach(System.out::println);
		
		System.out.println();
		System.out.println("Get By itemname");
		restaurantService.getByItemName("Soup").forEach(System.out::println);
		
		System.out.println();
		System.out.println("Get By itemtype and cuisine");
		restaurantService.getByCuisineItemType(CUISINE.SI.getCuisineType(),"BREAKFAST").forEach(System.out::println);
		

		
		

	}

}
