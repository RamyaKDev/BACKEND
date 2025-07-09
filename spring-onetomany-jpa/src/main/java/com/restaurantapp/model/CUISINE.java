package com.restaurantapp.model;

public enum CUISINE {
	SI("SOUTH INDIAN"),
	NI("NORTH INDIAN"),
	IT("ITALIAN"),
	CON("CONTINENTAL"),
	CH("CHINESE");

	private String cuisineType;
	private CUISINE(String cuisineType) {
		this.cuisineType=cuisineType;
	}
	public String getCuisineType() {
		return cuisineType;
	}
	
	
	
}
