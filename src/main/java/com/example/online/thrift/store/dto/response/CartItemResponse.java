package com.example.online.thrift.store.dto.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class CartItemResponse {
    private Long id;
    private Long quantity;
    private Long cartId;
    private Long productId;
}
