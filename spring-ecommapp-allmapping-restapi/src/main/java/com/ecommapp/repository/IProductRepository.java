package com.ecommapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ecommapp.model.Product;
@Repository
public interface IProductRepository extends JpaRepository<Product, Integer>{
//Custom Query
	@Query("from Product p inner join p.brand p where p.brand=?1")
	List<Product> findByBrand(String brand);
	@Query("from Product p inner join p.category p where p.category=?1")
	List<Product> findByCategory(String category);
	@Query("from Product p inner join p.category p where p.category=?1and p.cost=?2")
	List<Product> findByCategoryAndPriceLessThanEqual(String category, double price);

}
