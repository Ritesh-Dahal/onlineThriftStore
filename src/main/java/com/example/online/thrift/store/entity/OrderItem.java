package com.example.online.thrift.store.entity;

import com.example.online.thrift.store.dto.request.OrderItemRequest;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long orderId;
    private Long productId;
    private Long quantity;
    private Double price;

    public OrderItem(OrderItemRequest orderItemRequest) {
        this.price = orderItemRequest.getPrice();
        this.quantity = orderItemRequest.getQuantity();
        this.productId = orderItemRequest.getProductId();
        this.orderId = orderItemRequest.getOrderId();
    }
}
