package com.restaurantapp.model;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data                                                                                                                                                                                                                  
@Entity
public class Item {
	@Column(length=30)
	private String itemName;
	@Id
	@GeneratedValue(generator="item_gen",strategy=GenerationType.AUTO)
	@SequenceGenerator(name="item_gen",sequenceName = "item_seq",initialValue = 100)
	private Integer itemId;
	@Column(length=20)
	private String itemType;//breakfast,lunch,dinner,dessert,soup
	@Column(length=20)
	private double price;
	
}
