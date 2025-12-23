package com.example.online.thrift.store.repository;

import com.example.online.thrift.store.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {

    Optional<CartItem> findByUserId(Long userId);

    List<CartItem> findAllByUserId(Long userId);
}
