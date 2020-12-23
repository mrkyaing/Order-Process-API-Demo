package com.prodev.code.test.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemsModel {
	
	private Long id;

	private int quantity;

	private double total;
	
	private Long proudctId;
}
