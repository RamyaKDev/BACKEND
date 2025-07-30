package com.productapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.productapp.exception.ProductNotFoundException;
import com.productapp.model.Product;
import com.productapp.model.ProductDto;
@Repository
public interface IProductRepository extends JpaRepository<Product, Integer>{
	
	
	//Derived Queries
	//findBy, readBy, queryBy, getBy <PropertyName>
	//Property name first letter should be upper case
	
	List<Product> findByBrand(String brand); //select * from product where brand=?
	List<Product> findByCategory(String category);//select * from product where category=?
	List<Product> findByCategoryAndPriceLessThanEqual(String category,double price);
	//select * from product where category=? And price<=?
	
//	custom query - pass JPQL pass the entity name "P" in capital
//	equivalent sql query-> select * from product where category=? and product_name like "%?%"
	
	@Query("from Product p where p.category=?1 and p.productName like ?2")
	List<Product> findByCatProductName(String category,String productName);
	
	@Query("from Product p where p.brand= :brand and p.price <= :mprice")
	
	List<Product> findByBrandPrice(@Param("brand")String brand,@Param("mprice")double price);
//Instead of ?1 place holder we can use :name by using @Param annotation for mapping
	//Named Query
	@Query(name = "findByCatBrand")
	List<Product> printByCatBrand(String category,String brand);	
	
	//Native Query- use column names cost - is the column name
	@Query(value="select * from product where category=?1 and cost=?2 ",nativeQuery=true)
	List<Product> getByCatPrice(String category,double price);
}
