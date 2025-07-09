package com.restaurantapp.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.restaurantapp.exception.RestaurantNotFoundException;
import com.restaurantapp.model.Restaurant;
import com.restaurantapp.model.RestaurantDto;
import com.restaurantapp.repository.IRestaurantRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RestaurantServiceImpl implements IRestaurantService{
private final IRestaurantRepository restRepository;
private final ModelMapper mapper;

	@Override
	public void addRestaurant(RestaurantDto restaurantDto) {
		Restaurant restaurant=mapper.map(restaurantDto, Restaurant.class);
		restRepository.save(restaurant);
		
	}

	@Override
	public void updateRestaurant(RestaurantDto restaurantDto) {
		Restaurant restaurant=mapper.map(restaurantDto, Restaurant.class);
		restRepository.save(restaurant);
		
	}

	@Override
	public void deleteRestaurant(int restaurantId) {
		restRepository.deleteById(restaurantId);
		
	}

	@Override
	public RestaurantDto getById(int restaurantId) {
		Restaurant restaurant=restRepository.findById(restaurantId)
				.orElseThrow(()->new RestaurantNotFoundException("invalid Id"));
		RestaurantDto restaurantDto=mapper.map(restaurant, RestaurantDto.class);		
		return restaurantDto;
	}

	@Override
	public List<RestaurantDto> getAll() {
		List<Restaurant> restaurants=	restRepository.findAll();
	
		return restaurants.stream()
			 .map((restaurant)->mapper.map(restaurant,RestaurantDto.class))
			 .toList();
	}

	@Override
	public List<RestaurantDto> getByCuisine(String cuisine) {
		List<Restaurant> restaurants=restRepository.findByCuisine(cuisine);
		if(restaurants.isEmpty())
			throw new RestaurantNotFoundException("specifed cusine is not available in the restaurant");
		return restaurants.stream()
				.map((restaurant)->mapper.map(restaurant, RestaurantDto.class))
				.toList();
	}

	@Override
	public List<RestaurantDto> getByCategory(String category) {
		List<Restaurant> restaurants=restRepository.findByCategory(category);
		if(restaurants.isEmpty())
			throw new RestaurantNotFoundException("specifed category is not available in the restaurant");
		return restaurants.stream()
				.map((restaurant)->mapper.map(restaurant, RestaurantDto.class))
				.toList();
	}

	@Override
	public List<RestaurantDto> getByCuisineItemType(String cuisine, String itemType) {
		List<Restaurant> restaurants=restRepository.findByCuisineItemType(cuisine, itemType);
		if(restaurants.isEmpty())
			throw new RestaurantNotFoundException("specifed cusine and itemType is not available in the restaurant");
		return restaurants.stream()
				.map((restaurant)->mapper.map(restaurant, RestaurantDto.class))
				.toList();
	}

	@Override
	public List<RestaurantDto> getByCategoryItemName(String category, String itemName) {
		List<Restaurant> restaurants = restRepository.findByCategoryItemName(category, "%"+itemName+"%");

		if(restaurants.isEmpty())
			throw new RestaurantNotFoundException(" specifed category and itemName is not available in the restaurant");
		return restaurants.stream()
				.map((restaurant)->mapper.map(restaurant, RestaurantDto.class))
				.toList();
	}

	@Override
	public List<RestaurantDto> getByItemName(String itemName) {
		List<Restaurant> restaurants=restRepository.findByItemName("%"+itemName+"%");
		if(restaurants.isEmpty())
			throw new RestaurantNotFoundException("specifed itemName is not available in the restaurant");
		return restaurants.stream()
				.map((restaurant)->mapper.map(restaurant, RestaurantDto.class))
				.toList();
	}

}
