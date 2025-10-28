package com.example.online.thrift.store.entity;

import com.example.online.thrift.store.dto.request.OrderItemRequest;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderItem {

    public OrderItem(OrderItemRequest orderItemRequest){
        this.quantity=orderItemRequest.getQuantity();
        this.price= orderItemRequest.getPrice();
        this.orderId=orderItemRequest.getOrderId();
        this.productId=orderItemRequest.getProductId();

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private Long quantity;
    private Double price;
    private Long orderId;
    private Long productId;


}
