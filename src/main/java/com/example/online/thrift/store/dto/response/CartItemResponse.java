package com.example.online.thrift.store.dto.response;

import com.example.online.thrift.store.entity.CartItem;
import com.example.online.thrift.store.entity.Product;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CartItemResponse {
    private Long quantity;
    private Long cartId;
    private Product product;

}
