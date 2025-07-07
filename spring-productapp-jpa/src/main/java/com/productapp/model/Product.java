package com.productapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
//@Table(name="Product_details")
@NamedQuery(name="findByCatBrand",query="from Product p where p.category=?1 and p.brand=?2")
public class Product {
	//@Column(length=20)
	private String productName;
	@Id
	@GeneratedValue
	private Integer productId;
	@Column(name="cost")
	private double price;
	//@Column(length=20)
	private String category;
	//@Column(length=30)
	private String brand;

}
