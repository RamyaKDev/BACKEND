package com.productapp;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.productapp.model.ProductDto;
import com.productapp.service.IProductService;

@SpringBootApplication
public class SpringProductappJpaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringProductappJpaApplication.class, args);
	}
	@Autowired
	private IProductService iProductService;
	@Override
	public void run(String... args) throws Exception {
		//create dto object
		
		ProductDto productDto=new ProductDto("Mobile", null, 20000,"Electronics","Samsung");
		//call the method of service layer
		iProductService.addProduct(productDto);
		
		ProductDto nproductDto=iProductService.getById(1);
		System.out.println(nproductDto);
		
		//update - call setter methods
		nproductDto.setPrice(30000);
		iProductService.updateProduct(nproductDto);
		
	}

}
