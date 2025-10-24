package com.example.online.thrift.store.dto.response;


import com.example.online.thrift.store.entity.OrderItem;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class OrderItemResponse {
    public OrderItemResponse(OrderItem orderItem){
        this.id = orderItem.getId();
        this.quantity=orderItem.getQuantity();
        this.price=orderItem.getPrice();
        this.orderId=orderItem.getOrderId();
        this.productId=orderItem.getProductId();

    }

    private Long id;
    private Long quantity;
    private Double price;
    private Long orderId;
    private Long productId;
}
