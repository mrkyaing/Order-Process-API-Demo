package com.prodev.code.test.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 */
@Entity
@Table(name = "customer")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	/**
	 * 
	 */
	private String name;

	/**
	 * 
	 */
	private String email;

	/**
	 * 
	 */
	private String phone;

	/**
	 * 
	 */
	private String address;
	@OneToOne(mappedBy = "customerId")//declare customerid in order table foreign key column
    private Orders order;
}