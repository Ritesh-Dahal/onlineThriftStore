package com.example.online.thrift.store.dto.response;

import com.example.online.thrift.store.entity.CartItem;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CartItemResponse {

    public CartItemResponse(CartItem cartItem){

        this.id = cartItem.getId();
        this.quantity= cartItem.getQuantity();
        this.cartId=cartItem.getCartId();
        this.productId=cartItem.getProductId();
    }


    private Long id;
    private Long quantity;
    private Long cartId;
    private Long productId;
}
