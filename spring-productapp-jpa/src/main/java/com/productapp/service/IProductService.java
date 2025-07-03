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
}
