package com.example.online.thrift.store.entity;

import com.example.online.thrift.store.dto.request.OrderRequest;
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

    public Order(OrderRequest orderRequest){

        this.orderDate = orderRequest.getOrderDate();
        this.status = orderRequest.getStatus();
        this.totalAmount = orderRequest.getTotalAmount();
        this.userId=orderRequest.getUserId();
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime orderDate;
    private Status  status;
    private Double totalAmount;
    private Long userId;
}
