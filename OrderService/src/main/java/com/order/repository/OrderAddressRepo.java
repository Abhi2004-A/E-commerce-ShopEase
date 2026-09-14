package com.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.order.entity.OrderAddress;

@Repository
public interface OrderAddressRepo extends JpaRepository<OrderAddress, Integer>{

}
