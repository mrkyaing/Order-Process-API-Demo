package com.prodev.code.test.entity;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Table(name = "orders")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Orders {



	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	
	private Long id;


	private Long orderno;


	private Date orderDate;


	private String status;

	@ManyToOne
    @JoinColumn(name = "customerId")//to create foreign key productId in orderitmes table 
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Customer customer;
	
	
	@OneToMany(mappedBy = "orders", cascade = CascadeType.ALL)
    private List<OrderItems> orderitems = new ArrayList<>();

}