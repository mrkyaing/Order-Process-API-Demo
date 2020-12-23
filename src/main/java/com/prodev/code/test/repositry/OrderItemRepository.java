package com.prodev.code.test.repositry;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prodev.code.test.entity.OrderItems;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItems, Long>{

}
