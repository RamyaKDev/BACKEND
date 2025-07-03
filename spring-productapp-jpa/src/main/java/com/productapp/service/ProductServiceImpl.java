package com.productapp.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productapp.exception.ProductNotFoundException;
import com.productapp.model.Product;
import com.productapp.model.ProductDto;
import com.productapp.repository.IProductRepository;
@Service
public class ProductServiceImpl implements IProductService{
	@Autowired
	private ModelMapper mapper;//using mapper dto is converted to entity
	
	private IProductRepository iProductRepository;
	
	public ProductServiceImpl(IProductRepository iProductRepository) {
		super();
		this.iProductRepository = iProductRepository;
	}

	
	
	@Override
	public void addProduct(ProductDto productDto) {
		//convert dto(productDto) to entity(product)
		Product product=mapper.map(productDto, Product.class);
		//save the entity
		//check for id-
		//if no ,autogenerate the id,create a new row
		//if yes, check for id is in db
		//if no,create a new row, if yes update the row
		iProductRepository.save(product);
	}

	@Override
	public void updateProduct(ProductDto productDto) {
		//convert dto(productDto) to entity(product)
		Product product=mapper.map(productDto, Product.class);
		//product should have id in it -then updates it
		iProductRepository.save(product);
	}

	@Override
	public void deleteProduct(int productId) {
		iProductRepository.deleteById(productId);
		
	}

	@Override
	public ProductDto getById(int productId) {
//		Optional<Product> productOpt=iProductRepository.findById(productId);
//		//check if opt is having value product entity
//		if(productOpt.isPresent()) {
//			//this return the product entity
//			Product product=productOpt.get();
//			//convert the entity into productDto object
//			ProductDto productDto=mapper.map(product, ProductDto.class);
//			return productDto;
//		}
//		return null;
		//get the value if present or throw exception
		Product product=iProductRepository.findById(productId)
	//	.orElseThrow(()->{new throw ProductNotFoundException("invalid id"))
	//					} //to convert as as single line code removed curly braces and throw keywords
		.orElseThrow(()->new ProductNotFoundException("invalid id"));
		ProductDto productDto=mapper.map(product,ProductDto.class );
		return productDto;
	}//orElseThrow()-If a value is present, returns the value, otherwise throws an exception produced by the exception supplying function

	@Override
	public List<ProductDto> getAll() {
		//findAll() retrieves all the products(entity) from db we have to convert them to dto.
		//it comes as a product list so we have to convert each one by one product to product dto object.
		// we can use for loop but instead of that used streams and map function
		
		List<Product> listofproducts= iProductRepository.findAll();
		return listofproducts.stream()
		.map(product->mapper.map(product, ProductDto.class))
		.collect(Collectors.toList());
	}

}
