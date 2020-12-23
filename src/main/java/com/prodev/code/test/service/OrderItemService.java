package com.prodev.code.test.service;

import java.util.List;

import com.prodev.code.test.entity.Customer;
import com.prodev.code.test.entity.OrderItems;
import com.prodev.code.test.entity.Orders;

public interface OrderItemService {
	Long create(OrderItems entity);
	void update(OrderItems entity);
	void delete(Long id);
	List<OrderItems> getAll();
	OrderItems getById(Long id);
}
