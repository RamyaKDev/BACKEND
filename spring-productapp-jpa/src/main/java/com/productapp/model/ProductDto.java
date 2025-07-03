package com.productapp.model;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data

public class ProductDto {
	
	private String productName;	
	private Integer productId;	
	private double price;
	private String category;	
	private String brand;

}
