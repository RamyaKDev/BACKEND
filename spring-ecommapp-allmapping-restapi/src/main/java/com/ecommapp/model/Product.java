package com.ecommapp.model;

import java.util.List;
import java.util.Set;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Product {
	@Column(length = 30)
	private String productName;
	@Id
	@GeneratedValue(generator = "prod_gen", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "prod_gen", sequenceName = "prod_seq", initialValue = 1)
	private Integer productId;
	@Column(name = "cost")
	private double price;
	// save the child entity before saving the parent entity
	@OneToOne(cascade = CascadeType.ALL)
	// to provide the different name for the column here it will come like
	// features_features_id. its too long dont want.
	@JoinColumn(name = "features_id")
	private Features features;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "product_id")
	private Set<Offers> offers;

	@ManyToOne
	@JoinColumn(name = "brand_id")
	private Brand brand;

	@ManyToMany
	@JoinTable(name = "product_Category", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
	private Set<Category> categories;

	@ElementCollection
	@CollectionTable(name = "payment", joinColumns = @JoinColumn(name = "product_id"))
	private List<String> paymentModes;// CashOnDelivery,UPI,CreditCard

	@ElementCollection
	@CollectionTable(name = "delivery", joinColumns = @JoinColumn(name = "product_id"))
	private List<String> deliveryTypes;// Standard,Prime,Free
}
