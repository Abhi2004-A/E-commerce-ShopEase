package com.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.order.entity.OrderItems;

@Repository
public interface OrderItemsRepo extends JpaRepository<OrderItems, Integer>{

}
