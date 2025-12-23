package com.example.online.thrift.store.dto.request;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CartItemRequest {
    private Long quantity;
    private Long cartId;
    private Long productId;
    private Long userId;
}
