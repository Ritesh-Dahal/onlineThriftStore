package com.example.online.thrift.store.dto.response;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class OrderItemResponse {
    private Long id;
    private Long quantity;
    private Double price;
    private Long orderId;
    private Long productId;
}
