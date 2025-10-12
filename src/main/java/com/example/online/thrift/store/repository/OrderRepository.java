package com.example.online.thrift.store.repository;

import com.example.online.thrift.store.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}
