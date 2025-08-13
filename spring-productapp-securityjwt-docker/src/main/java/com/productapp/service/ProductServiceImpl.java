package com.productapp.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.productapp.exception.ProductNotFoundException;
import com.productapp.model.Product;
import com.productapp.model.ProductDto;
import com.productapp.repository.IProductRepository;
@Service
public class ProductServiceImpl implements IProductService {
	@Autowired
	private IProductRepository productRepository;
	@Autowired
	private ModelMapper mapper;
	@Override
	public void addProduct(ProductDto productDto) {
		Product product=mapper.map(productDto,Product.class);
		productRepository.save(product);
	}

	@Override
	public void updateProduct(ProductDto productDto) {
		Product product=mapper.map(productDto,Product.class);
		productRepository.save(product);
		
	}

	@Override
	public void deleteProduct(int productId) {
		productRepository.deleteById(productId);
		
	}

	@Override
	public ProductDto getById(int productId) throws ProductNotFoundException {
		Product product=productRepository.findById(productId)
				.orElseThrow(()->new ProductNotFoundException("invalid productid"));
		
		return mapper.map(product,ProductDto.class);
	}


	@Override
	public List<ProductDto> getAll() {
		List<Product> products = productRepository.findAll();
		return products.stream().map(product -> mapper.map(product, ProductDto.class))
						 .sorted((p1,p2)->p1.getProductName().compareTo(p2.getProductName()))
				         .collect(Collectors.toList());

	}


	@Override
	public List<ProductDto> getByBrand(String brand) throws ProductNotFoundException {
		List<Product> products = productRepository.findByBrand(brand);
		if (products.isEmpty())
			throw new ProductNotFoundException("brand not found");
		return products.stream().map(product -> mapper.map(product, ProductDto.class)).collect(Collectors.toList());
		
	}

	@Override
	public List<ProductDto> getByCategory(String category) throws ProductNotFoundException {
		List<Product> products = productRepository.findByCategory(category);
		if (products.isEmpty())
			throw new ProductNotFoundException("category not found");
		return products.stream().map(product -> mapper.map(product, ProductDto.class)).collect(Collectors.toList());
	}

	@Override
	public List<ProductDto> getByCatLessPrice(String category, double price) throws ProductNotFoundException {
		List<Product> products = productRepository.findByCategoryPrice(category, price);
		if (products.isEmpty())
			throw new ProductNotFoundException("products with category and price with less amount not available");
		return products.stream().map(product -> mapper.map(product, ProductDto.class)).collect(Collectors.toList());
	}

	@Override
	@Transactional
	public void updateProductPrice(int productId, double price) {
		productRepository.updateProduct(productId, price);
	}


}
