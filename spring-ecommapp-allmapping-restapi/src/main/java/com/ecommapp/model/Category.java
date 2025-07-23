package com.ecommapp.model;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Category {
	@Id
	@GeneratedValue(generator = "category_gen",strategy = GenerationType.AUTO)
	@SequenceGenerator(name ="category_gen",sequenceName = "category_seq",initialValue = 201,allocationSize = 1 )
private Integer categoryId;
private String categoryName;

@ManyToMany(mappedBy = "categories")
@ToString.Exclude
private Set<Product> products;
}
