package com.example.online.thrift.store.dto.response;

import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CartItemResponse {
    private Long id;
    private Long quantity;
    private Long cartId;
    private Long productId;
}
