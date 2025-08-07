package com.productapp.service;

import com.productapp.exception.CategoryNotFoundException;
import com.productapp.model.CategoryDto;

public interface ICategoryService {
//CRUD Operation
	void addCategory(CategoryDto categoryDto);
	void updateCategory(CategoryDto categoryDto);
	void deleteCategory(int categoryId);
	CategoryDto getById(int categoryId)throws CategoryNotFoundException;
	
	
	
}
