package com.ecommapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ecommapp.model.BrandDto;
import com.ecommapp.model.CategoryDto;
import com.ecommapp.service.IBrandService;
import com.ecommapp.service.ICategoryService;

@SpringBootApplication
public class SpringEcommappAllmappingRestapiApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringEcommappAllmappingRestapiApplication.class, args);
	}
	
	@Autowired
	private IBrandService brandService;
	@Autowired
	private ICategoryService categoryService;
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
//		BrandDto brandDto=new BrandDto("Samsung");
//		brandService.addBrand(brandDto);
//		
//		brandDto=new BrandDto("Adidas");
//		brandService.addBrand(brandDto);
//		
//		brandDto=new BrandDto("Dell");
//		brandService.addBrand(brandDto);
//		
//		brandDto=new BrandDto("Lavie");
//		brandService.addBrand(brandDto);
//		
//		CategoryDto categoryDto=new CategoryDto("Electronics");
//		categoryService.addCategory(categoryDto);
//		
//		categoryDto=new CategoryDto("Sports");
//		categoryService.addCategory(categoryDto);
//		
//		categoryDto=new CategoryDto("Bags");
//		categoryService.addCategory(categoryDto);
	}

}
