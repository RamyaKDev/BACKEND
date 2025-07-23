package com.ecommapp.model;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class CategoryDto {

	private Integer categoryId;
	private String categoryName;
	@ToString.Exclude
	private Set<Product> products;
}
