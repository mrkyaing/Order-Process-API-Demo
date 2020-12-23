package com.prodev.code.test.service;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prodev.code.test.entity.Customer;
import com.prodev.code.test.entity.Orders;
import com.prodev.code.test.model.OrderModel;
import com.prodev.code.test.repositry.CustomerRepository;
import com.prodev.code.test.repositry.OrderRepository;


@Service
public class OrderServiceImp implements OrderService{
@Autowired
OrderRepository repo;
@Autowired 
CustomerRepository custorepo;
@Override
public Long create(OrderModel entity) {
	if (repo.findByorderno(entity.getOrderno()).isPresent()) {
		throw new EntityExistsException(
		"Orders No is already exist with " + entity.getOrderno() + ". Please create another Orders No.") ;
	}
    final Orders order=new Orders();
    order.setOrderDate(entity.getOrderDate());
    order.setOrderno(entity.getOrderno());
    order.setStatus(entity.getStatus());
    Customer customer=custorepo.findById(entity.getCustomerId()).get();
    if(customer==null)throw new EntityExistsException(
    		"Customer id is not  exist with " + entity.getCustomerId() + ". Please choose another customer.") ;
    order.setCustomerId(customer);
	
    return this.repo.save(order).getId();
}

@Override
public void update(OrderModel entity) {
	if (repo.existsById(entity.getId()))
		{
		  final Orders order=new Orders();
		    order.setOrderDate(entity.getOrderDate());
		    order.setOrderno(entity.getOrderno());
		    order.setStatus(entity.getStatus());
		    Customer customer=new Customer();
		    customer.setId(entity.getCustomerId());
		    order.setCustomerId(customer);
		}
	else
		throw new EntityNotFoundException(
				"Orders  with id : " + entity.getId() + "is not found to update. Please create first.");

}

@Override
public void delete(Long id) {
	if (repo.existsById(id))
		repo.deleteById(id);
	else
		throw new EntityNotFoundException("Orders  with id : " + id + "is not found to delete. Please create first.");
	
}

@Override
public List<Orders> getAll() {
	return this.repo.findAll();
}

@Override
public Orders getById(Long id) {
	if (repo.existsById(id)) {
		return repo.findById(id).get();
	}
		
	else
		throw new EntityNotFoundException("Orders  with id : " + id + "is not found to get. Please create first.");
	
}

}
