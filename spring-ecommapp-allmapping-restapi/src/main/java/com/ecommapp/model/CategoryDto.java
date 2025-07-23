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

	public CategoryDto(String categoryName) {
		super();
		this.categoryName = categoryName;
	}
	private Integer categoryId;
	private String categoryName;
	@ToString.Exclude
	private Set<Product> products;
}
