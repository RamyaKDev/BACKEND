package com.ecommapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class OffersDto {

	private Integer offerId;
	private String offerType;// No cost emi ,cash back ,bank offer
	private String description;
}
