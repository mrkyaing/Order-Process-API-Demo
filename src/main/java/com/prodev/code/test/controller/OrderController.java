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

import com.prodev.code.test.entity.Orders;
import com.prodev.code.test.model.OrderModel;
import com.prodev.code.test.service.OrderService;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {

	@Autowired
	private OrderService service; 

	@PostMapping
	public ResponseEntity<String> create(@Validated @RequestBody OrderModel entity) {

		Long id = service.create(entity);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Location", "/api/v1/" + id);
		return new ResponseEntity<>(null, HttpStatus.CREATED);
	}

	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	public void update(@Validated @RequestBody OrderModel entity) {

		this.service.update(entity);

	}

	@DeleteMapping("{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable("id") Long id) {

		this.service.delete(id);
	}
	@GetMapping
	public ResponseEntity<List<Orders>> getAll() {

		List<Orders> dataList =this.service.getAll();

		return new ResponseEntity<>(dataList, HttpStatus.OK);
	}
	@GetMapping("/{id}")
	public ResponseEntity<Orders> getById(@PathVariable("id") Long id){
		Orders data=this.service.getById(id);
		return new ResponseEntity<>(data, HttpStatus.OK);
	}
	
}
