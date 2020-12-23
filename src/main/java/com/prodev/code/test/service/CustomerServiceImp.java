package com.prodev.code.test.service;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prodev.code.test.entity.Customer;
import com.prodev.code.test.entity.Product;
import com.prodev.code.test.repositry.CustomerRepository;
import com.prodev.code.test.repositry.ProductRepository;

@Service
public class CustomerServiceImp implements CustomerService{
@Autowired
CustomerRepository repo;

@Override
public Long create(Customer entity) {
	if (repo.findByNameIgnoreCase(entity.getName()).isPresent()) {
		throw new EntityExistsException(
		"Customer name is already exist with " + entity.getName() + ". Please create another product.") ;
	}

	return this.repo.save(entity).getId();
}

@Override
public void update(Customer entity) {
	if (repo.existsById(entity.getId()))
		repo.save(entity);
	else
		throw new EntityNotFoundException(
				"Customer with id : " + entity.getId() + " is not found to update. Please create first.");

}

@Override
public void delete(Long id) {
	if (repo.existsById(id))
		repo.deleteById(id);
	else
		throw new EntityNotFoundException("Customer with id : " + id + " is not found to delete. Please create first.");
	
}

@Override
public List<Customer> getAll() {
	return this.repo.findAll();
}

@Override
public Customer getById(Long id) {
	if (repo.existsById(id)) {
		return repo.findById(id).get();
	}
		
	else
		throw new EntityNotFoundException("Customer with id : " + id + " is not found to get. Please create first.");
	
}

}
