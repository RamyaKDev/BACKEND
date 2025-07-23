package com.ecommapp.service;

import com.ecommapp.exception.CategoryNotFoundException;
import com.ecommapp.model.CategoryDto;

public interface ICategoryService {
//CRUD Operation
	void addCategory(CategoryDto categoryDto);
	void updateCategory(CategoryDto categoryDto);
	void deleteCategory(int categoryId);
	CategoryDto getById(int categoryId)throws CategoryNotFoundException;
	
	
	
}
