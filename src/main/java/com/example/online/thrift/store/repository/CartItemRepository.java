package com.example.online.thrift.store.repository;

import com.example.online.thrift.store.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {

    List<CartItem> findByUserId(Long userId);
    Optional<CartItem> deleteByProductId(Long productId);

    List<CartItem> findAllByUserId(Long userId);
}
