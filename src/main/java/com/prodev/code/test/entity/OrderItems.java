package com.prodev.code.test.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 */
@Entity
@Table(name = "orderItems")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderItems {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;


	/**
	 * 
	 */
	private int quantity;

	/**
	 * 
	 */
	private double total;

	@ManyToOne
    @JoinColumn(name = "ordersId")//to create foreign key ordersId in orderitmes table 
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Orders orders;
	
	
	@ManyToOne
    @JoinColumn(name = "productId")//to create foreign key productId in orderitmes table 
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Product product;
	
	

}