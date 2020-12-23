package com.prodev.code.test.service;

import java.util.List;

import com.prodev.code.test.entity.Orders;
import com.prodev.code.test.model.OrderModel;

public interface OrderService {
	Long create(OrderModel entity);
	void update(OrderModel entity);
	void delete(Long id);
	List<Orders> getAll();
	Orders getById(Long id);
}
