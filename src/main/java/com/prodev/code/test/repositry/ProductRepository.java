package com.prodev.code.test.repositry;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prodev.code.test.entity.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
Optional<Product> findByNameIgnoreCase(String name);
}
