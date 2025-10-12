package com.example.online.thrift.store.entity;

import com.example.online.thrift.store.enums.Status;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime orderDate;
    private Status  status;
    private Double totalAmount;
    private Long userId;
}
