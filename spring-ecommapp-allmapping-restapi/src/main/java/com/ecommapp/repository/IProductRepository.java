package com.ecommapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ecommapp.model.Product;
@Repository
public interface IProductRepository extends JpaRepository<Product, Integer>{
	//For derived Query it should go like this
	//List<Product> findByBrandBrandName(String brand);
	//List<Product> findByCategoriesCategoryName(String category);
	//
	
	//Custom Query
	
	
	@Query("from Product p inner join p.brand b where b.brandName=?1")
	List<Product> findByBrand(String brand);
	@Query("from Product p inner join p.categories c where c.categoryName=?1")
	List<Product> findByCategory(String category);
	@Query(
			"""
			from Product p inner join p.categories c where c.categoryName= :categoryName and 
			p.price <= :price			
			""")
	List<Product> findByCategoryPrice(@Param("categoryName") String category, @Param("price") double price);
	
	//nativeQuery
	//use column name and table name
		@Query(value = "update product set cost=?2 where product_id=?1",nativeQuery = true)
		@Modifying
		void updateProduct(int productId, double price);

}
