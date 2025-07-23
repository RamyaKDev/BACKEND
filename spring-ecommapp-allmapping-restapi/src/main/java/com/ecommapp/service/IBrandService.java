package com.ecommapp.service;

import java.util.List;

import com.ecommapp.exception.BrandNotFoundException;
//import com.ecommapp.exception.BrandNotFoundException;
import com.ecommapp.model.BrandDto;

public interface IBrandService {
//CRUD Operation
	void addBrand(BrandDto brandDto);
	void updateBrand(BrandDto brandDto);
	void deleteBrand(int brandId);
	BrandDto getById(int brandId)throws BrandNotFoundException;
	
	
	
}
