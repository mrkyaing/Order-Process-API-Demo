package com.prodev.code.test.service;

import java.util.List;

import com.prodev.code.test.entity.Customer;

public interface CustomerService {
	Long create(Customer entity);
	void update(Customer entity);
	void delete(Long id);
	List<Customer> getAll();
	Customer getById(Long id);
}
