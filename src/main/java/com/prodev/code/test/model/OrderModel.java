package com.prodev.code.test.model;

import java.util.Date;


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
public class OrderModel {
	
	private Long id;
	
	private Long orderno;


	private Date orderDate;


	private String status;
	
	 private Long customerId;
}
