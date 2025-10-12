package com.example.online.thrift.store.repository;

import com.example.online.thrift.store.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart,Long> {
}
