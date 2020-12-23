package com.prodev.code.test.service;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prodev.code.test.entity.Product;
import com.prodev.code.test.repositry.ProductRepository;

@Service
public class ProductServiceImp implements ProductService{
@Autowired
ProductRepository productrepo;

@Override
public Long create(Product entity) {
	if (productrepo.findByNameIgnoreCase(entity.getName()).isPresent()) {
		throw new EntityExistsException(
		"product name is already exist with " + entity.getName() + ". Please create another product.") ;
	}

	return this.productrepo.save(entity).getId();
}

@Override
public void update(Product entity) {
	if (productrepo.existsById(entity.getId()))
		productrepo.save(entity);
	else
		throw new EntityNotFoundException(
				"Product with id : " + entity.getId() + "is not found to update. Please create first.");

}

@Override
public void delete(Long id) {
	if (productrepo.existsById(id))
		productrepo.deleteById(id);
	else
		throw new EntityNotFoundException("Proudct with id : " + id + "is not found to delete. Please create first.");
	
}

@Override
public List<Product> getAll() {
	return this.productrepo.findAll();
}

@Override
public Product getById(Long id) {
	if (productrepo.existsById(id)) {
		return productrepo.findById(id).get();
	}
		
	else
		throw new EntityNotFoundException("Proudct with id : " + id + "is not found to get. Please create first.");
	
}

}
