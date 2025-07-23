package com.ecommapp.service;

import java.util.List;

import com.ecommapp.exception.ProductNotFoundException;
import com.ecommapp.model.ProductDto;

public interface IProductService {
//CRUD Operation
	void addProduct(ProductDto productDto);
	void updateProduct(ProductDto productDto);
	void deleteProduct(int productId);
	ProductDto getById(int productId)throws ProductNotFoundException;
	List<ProductDto> getAll();
	
	//Derived Queries
	List<ProductDto> getByBrand( String brand)throws ProductNotFoundException;
	List<ProductDto> getByCategory( String category)throws ProductNotFoundException;
	List<ProductDto> getByCatLessPrice(String category,double price)throws ProductNotFoundException;
}
