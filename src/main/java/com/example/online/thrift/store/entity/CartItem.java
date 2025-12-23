package com.example.online.thrift.store.entity;

import com.example.online.thrift.store.dto.request.CartItemRequest;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CartItem {

    public CartItem (CartItemRequest cartItemRequest){
        this.quantity = cartItemRequest.getQuantity();
        this.cartId=cartItemRequest.getCartId();
        this.productId=cartItemRequest.getProductId();
        this.userId = cartItemRequest.getUserId();
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long userId;
    private Long quantity;
    private Long cartId;
    private Long productId;


}
