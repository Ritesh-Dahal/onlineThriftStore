package com.example.online.thrift.store.repository;

import com.example.online.thrift.store.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment,Long> {
}
