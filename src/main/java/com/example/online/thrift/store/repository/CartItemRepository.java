package com.example.online.thrift.store.repository;

import com.example.online.thrift.store.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem,Long> {
}
