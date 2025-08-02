package com.productapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.productapp.model.ProductDto;
import com.productapp.model.ProductPriceDto;
import com.productapp.service.IProductService;

@RestController
@RequestMapping("/products-api/v1")
public class ProductController {
	@Autowired
	private IProductService productService;
	
	//http://localhost:8081/products-api/v1/products
	@PostMapping("/products")
	ResponseEntity<Void> addProduct(@RequestBody ProductDto productDto){
		productService.addProduct(productDto);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	//http://localhost:8081/products-api/v1/products
	@PutMapping("/products")
	ResponseEntity<Void> updateProduct(@RequestBody ProductDto productDto){
		productService.updateProduct(productDto);
		HttpHeaders headers=new HttpHeaders();
		headers.add("info", "updating one product");
		headers.add("desc","update method called");
		return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).build();
	}
	
	//http://localhost:8081/products-api/v1/products
		@PatchMapping("/products/newprice")
		ResponseEntity<Void> updateProduct(@RequestBody ProductPriceDto productpriceDto){
			double price=productpriceDto.getPrice();
			int productId=productpriceDto.getProductId();
			productService.updateProductPrice(productId, price);
			return ResponseEntity.status(HttpStatus.ACCEPTED).build();
		}
	
	//http://localhost:8081/products-api/v1/products/productId/2
	@DeleteMapping("/products/productId/{productId}")
	ResponseEntity<Void> deleteProduct(@PathVariable int productId){
		productService.deleteProduct(productId);
		HttpHeaders headers =new HttpHeaders();
		headers.add("info", "delete one product by id");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).build();
	}
	
	//http://localhost:8081/products-api/v1/products/productId/1
	@GetMapping("/products/productId/{productId}")
	ResponseEntity<ProductDto> getById(@PathVariable int productId){
		ProductDto productDto=	productService.getById(productId);
		HttpHeaders headers=new HttpHeaders();
		headers.add("info", "getting one products by id ");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(productDto);
	}
	
//	 http://localhost:8081/product-api/v1/products
	@GetMapping("/products")
	ResponseEntity<List<ProductDto>> getAll(){
		List<ProductDto> productDtos = productService.getAll();
   	HttpHeaders headers =  new HttpHeaders();
		headers.add("info","getting all products");
		return ResponseEntity.ok().headers(headers).body(productDtos);
	}

	
	//http://localhost:8081/products-api/v1/products/brand/samsung
	@GetMapping("/products/brand/{brand}")
	ResponseEntity<List<ProductDto>> getByBrand(@PathVariable String brand){
		List<ProductDto> products=productService.getByBrand(brand);
		HttpHeaders headers=new HttpHeaders();
		headers.add("info", "getting all products by brand ");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(products);
	}
	
	//http://localhost:8081/products-api/v1/products/category?category=electronics
	@GetMapping("/products/category")
	ResponseEntity<List<ProductDto>> getByCategory(@RequestParam String category){
		List<ProductDto> products=productService.getByCategory(category);
		HttpHeaders headers=new HttpHeaders();
		headers.add("info", "getting all products by category ");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(products);
	}
	
	//http://localhost:8081/products-api/v1/products/category/electronics/price/2000
	@GetMapping("/products/category/{category}/price/{price}")
	ResponseEntity<List<ProductDto>> getByCatLessPrice(@PathVariable String category,@PathVariable double price){
		List<ProductDto> products=productService.getByCatLessPrice(category, price);
		HttpHeaders headers=new HttpHeaders();
		headers.add("info", "getting all products by category and price");
		return ResponseEntity.status(HttpStatus.OK).headers(headers).body(products);
	}
}
