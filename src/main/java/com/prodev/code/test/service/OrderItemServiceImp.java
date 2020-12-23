package com.prodev.code.test.service;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prodev.code.test.entity.Customer;
import com.prodev.code.test.entity.OrderItems;
import com.prodev.code.test.entity.Orders;
import com.prodev.code.test.repositry.CustomerRepository;
import com.prodev.code.test.repositry.OrderItemRepository;
import com.prodev.code.test.repositry.OrderRepository;
import com.prodev.code.test.repositry.ProductRepository;


@Service
public class OrderItemServiceImp implements OrderItemService{
@Autowired
OrderItemRepository repo;

	@Override
	public Long create(OrderItems entity) {
			
	    return this.repo.save(entity).getId();
	}

	@Override
	public void update(OrderItems entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<OrderItems> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderItems getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
