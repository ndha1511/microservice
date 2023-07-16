package com.microservicedemo.orderservice.repositories;

import com.microservicedemo.orderservice.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
