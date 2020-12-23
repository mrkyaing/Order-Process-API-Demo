package com.prodev.code.test.service;

import java.util.List;

import com.prodev.code.test.entity.Product;

public interface ProductService {
	Long create(Product entity);
	void update(Product entity);
	void delete(Long id);
	List<Product> getAll();
	Product getById(Long id);
}
