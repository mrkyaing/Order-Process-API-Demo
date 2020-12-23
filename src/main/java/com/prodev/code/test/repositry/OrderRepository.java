package com.prodev.code.test.repositry;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prodev.code.test.entity.Orders;

@Repository
public interface OrderRepository extends JpaRepository<Orders, Long>{
Optional<Orders> findByorderno(Long OrderNo);
}
