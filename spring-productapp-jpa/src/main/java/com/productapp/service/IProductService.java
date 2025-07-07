package com.productapp.service;

import java.util.List;

import com.productapp.exception.ProductNotFoundException;
import com.productapp.model.ProductDto;

public interface IProductService {
	//CRUD Operation
	void addProduct(ProductDto productDto);
	void updateProduct(ProductDto productDto);
	void deleteProduct(int productId);
	ProductDto getById(int productId) throws ProductNotFoundException;
	List<ProductDto> getAll();
	
	//Derived Queries
	List<ProductDto> getByBrand(String brand)throws ProductNotFoundException;
	List<ProductDto> getByCategory(String category)throws ProductNotFoundException;
	List<ProductDto> getByCatLessPrice(String category,double price)throws ProductNotFoundException;
	
	//Custom Queries
	List<ProductDto> getByCatNameContains(String category,String productName)throws ProductNotFoundException;
	List<ProductDto> getByBrandPrice(String brand,double price)throws ProductNotFoundException;
	
	//Named Query
	List<ProductDto> getByCatBrand(String category,String brand);
	
	
	//Native Query
	
	List<ProductDto> getByCatPrice(String category,double price);
}
