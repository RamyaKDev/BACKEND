package com.employeeapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class AddressDto {
	private String city;
	private Integer addressId;
	private String state;
}
