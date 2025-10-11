package com.example.online.thrift.store.dto.request;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class CartItemRequest {
    private Long quantity;
    private Long cartId;
    private Long productId;
}
