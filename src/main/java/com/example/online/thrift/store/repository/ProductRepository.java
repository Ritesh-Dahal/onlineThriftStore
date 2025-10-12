package com.example.online.thrift.store.repository;

import com.example.online.thrift.store.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
