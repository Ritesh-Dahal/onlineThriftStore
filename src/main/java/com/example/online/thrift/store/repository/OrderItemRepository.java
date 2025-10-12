package com.example.online.thrift.store.repository;

import com.example.online.thrift.store.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem,Long> {
}
