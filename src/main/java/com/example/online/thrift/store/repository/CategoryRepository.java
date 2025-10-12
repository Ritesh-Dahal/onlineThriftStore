package com.example.online.thrift.store.repository;

import com.example.online.thrift.store.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
