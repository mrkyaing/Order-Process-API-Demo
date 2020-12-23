package com.prodev.code.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.prodev.code.test.entity.Product;
import com.prodev.code.test.service.ProductService;


@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

	@Autowired
	private ProductService productservice; 

	@PostMapping
	public ResponseEntity<String> create(@Validated @RequestBody Product entity) {

		Long id = productservice.create(entity);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Location", "/api/v1/" + id);
		return new ResponseEntity<>(null, HttpStatus.CREATED);
	}

	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	public void update(@Validated @RequestBody Product entity) {

		this.productservice.update(entity);

	}

	@DeleteMapping("{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable("id") Long id) {

		this.productservice.delete(id);
	}
	@GetMapping
	public ResponseEntity<List<Product>> getAll() {

		List<Product> productlist =this.productservice.getAll();

		return new ResponseEntity<>(productlist, HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Product> getById(@PathVariable("id") Long id){
		Product product=this.productservice.getById(id);
		return new ResponseEntity<>(product, HttpStatus.OK);
	}
	
}
