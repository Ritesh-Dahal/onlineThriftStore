package com.example.online.thrift.store.dto.response;

import com.example.online.thrift.store.entity.OrderItem;
import com.example.online.thrift.store.entity.Product;

public class OrderProductResponse {

    private OrderItem orderItem;
    private Product product;

    public OrderProductResponse(OrderItem orderItem, Product product) {
        this.orderItem = orderItem;
        this.product = product;
    }

    public OrderItem getOrderItem() {
        return orderItem;
    }

    public Product getProduct() {
        return product;
    }
}
