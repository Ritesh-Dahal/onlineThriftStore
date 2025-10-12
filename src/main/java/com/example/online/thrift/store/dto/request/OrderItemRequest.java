package com.example.online.thrift.store.dto.request;

import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class OrderItemRequest {
    private Long quantity;
    private Double price;
    private Long orderId;
    private Long productId;
}
