package com.prodev.code.test.repositry;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prodev.code.test.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{
Optional<Customer> findByNameIgnoreCase(String name);
}
