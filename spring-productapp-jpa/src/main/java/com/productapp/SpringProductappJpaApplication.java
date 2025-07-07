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
		productDto=new ProductDto("Laptop", null, 50000,"Electronics","Dell");		
		iProductService.addProduct(productDto);
		productDto=new ProductDto("Ipad", null, 15000,"Electronics","Lenovo");	
		iProductService.addProduct(productDto);
		productDto =  new ProductDto("Ear Phones", null, 6000, "Electronics","Boat");
		iProductService.addProduct(productDto);
		productDto =  new ProductDto("Toy Phones", null, 3200, "Electronics","Samsung");
		iProductService.addProduct(productDto);
		productDto=new ProductDto("Camera", null, 1000,"Electronics","logi");
		iProductService.addProduct(productDto);
		productDto=new ProductDto("Table", null, 5000,"Furniture","IKEA");	
		iProductService.addProduct(productDto);
		productDto=new ProductDto("Sofa", null, 25500,"Furniture","IKEA");	
		iProductService.addProduct(productDto);
		productDto=new ProductDto("Shoes", null, 3500,"Sports","Nike");		
		iProductService.addProduct(productDto);
		productDto=new ProductDto("Jacket", null, 5020,"Sports","Adidas");
		iProductService.addProduct(productDto);
		
		System.out.println();
		//Displaying all the products here
		System.out.println("Get All Products");
		iProductService.getAll().forEach(System.out::println);
		//Here it comes as a list so we need to iterate them one by one by using foreach and method reference 
		
		System.out.println();
		//fetching product by id
		ProductDto nproductDto=iProductService.getById(1);
		System.out.println(nproductDto);
		
		System.out.println();
		//update - call setter methods
		nproductDto.setPrice(30000);
		iProductService.updateProduct(nproductDto);
		System.out.println();
		System.out.println("Updated by ID");
		nproductDto=iProductService.getById(1);
		System.out.println(nproductDto);
		//displaying again after the product is updated by id
		
		
		System.out.println();
		// Displaying the products by Brand
		System.out.println("Get the products by Brand");
		iProductService.getByBrand("IKEA").forEach(System.out::println);
		
		System.out.println();
		// Displaying the products by Category
		System.out.println("Get the products by Category");
		iProductService.getByCategory("Electronics").forEach(System.out::println);
		
		System.out.println();
		// Displaying the products by category and less price
		System.out.println("Get the products by category and less price");
		iProductService.getByCatLessPrice("Electronics", 10000).forEach(System.out::println);
		
		System.out.println();
		System.out.println("Custom - Get By category with name contains");
		iProductService.getByCatNameContains("Electronics","Phones").stream().forEach(System.out::println);
		
		System.out.println();
		System.out.println("Custom - Get By brand and less price");
		iProductService.getByBrandPrice("Samsung",8000).stream().forEach(System.out::println);
		
		System.out.println();
		System.out.println("Named - Get By category and brand");
		iProductService.getByCatBrand("Electronics","Dell").stream().forEach(System.out::println);
		
		System.out.println();
		System.out.println("Native Query - Get By category with less price");
		iProductService.getByCatLessPrice("Sports", 9000).stream().forEach(System.out::println);
		
	}

}
