package com.example.online.thrift.store.repository;

import com.example.online.thrift.store.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrderItemRepository extends JpaRepository<OrderItem,Long> {
    Optional<OrderItem> findByUserId(Long id);

}
