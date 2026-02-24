package com.example.online.thrift.store.repository;

import com.example.online.thrift.store.entity.Order;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    @Query("""
    SELECT o.userId
    FROM Order o
    GROUP BY o.Id
    ORDER BY COUNT(o.Id) DESC
""")
    List<Long> findTopUserIds(Pageable pageable);

    List<Order> findByUserId(Long userId);

}
