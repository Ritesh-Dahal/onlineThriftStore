package com.example.online.thrift.store.dto.response;

import com.example.online.thrift.store.entity.OrderItem;
import com.example.online.thrift.store.entity.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrderItemProductResponse {

    private OrderItem orderItem;   // order item data
    private Product product;       // product data

    public OrderItemProductResponse(OrderItem orderItem, Product product) {
        this.orderItem = orderItem;
        this.product = product;
    }


}
