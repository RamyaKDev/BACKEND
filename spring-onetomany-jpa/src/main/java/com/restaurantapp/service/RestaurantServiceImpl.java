package com.restaurantapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.restaurantapp.model.RestaurantDto;

@Service
public class RestaurantServiceImpl implements IRestaurantService{

	@Override
	public void addRestaurant(RestaurantDto restaurantDto) {
		
		
	}

	@Override
	public void updateRestaurant(RestaurantDto restaurantDto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteRestaurant(int restaurantId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public RestaurantDto getById(int restaurantId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RestaurantDto> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RestaurantDto> getByCuisine(String cuisine) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RestaurantDto> getByCategory(String category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RestaurantDto> getByCuisineItemType(String cuisine, String itemType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RestaurantDto> getByCategoryItemName(String category, String itemName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RestaurantDto> getByItemName(String itemName) {
		// TODO Auto-generated method stub
		return null;
	}

}
