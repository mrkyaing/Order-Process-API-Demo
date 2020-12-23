package com.prodev.code.test.model;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;
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
	   @NotNull
	private Long orderno;

	   @NotNull
	private Date orderDate;


	private String status;
	   @NotNull
	 private Long customerId;
	   

	private List<OrderItemsModel> orderItems;
}
