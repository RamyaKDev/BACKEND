package com.ecommapp.service;

import java.util.List;

import com.ecommapp.exception.ProductNotFoundException;
import com.ecommapp.model.ProductDto;
import com.ecommapp.model.ProductPriceDto;

public interface IProductService {
//CRUD Operation
	void addProduct(ProductDto productDto);
	void updateProduct(ProductDto productDto);
	void deleteProduct(int productId);
	ProductDto getById(int productId)throws ProductNotFoundException;
	List<ProductDto> getAll();
	
	//Custom Queries
	List<ProductDto> getByBrand( String brand)throws ProductNotFoundException;
	List<ProductDto> getByCategory( String category)throws ProductNotFoundException;	
	List<ProductDto> getByCatLessPrice(String category,double price)throws ProductNotFoundException;
	
	//Native Query
	void updateProductPrice(int productId,double price);
}
