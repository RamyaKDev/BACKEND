package com.productapp.model;

import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	@JsonIgnore
	private List<Product> products;
}
