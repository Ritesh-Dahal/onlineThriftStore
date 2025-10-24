package com.example.online.thrift.store.dto.response;

import com.example.online.thrift.store.entity.Cart;
import lombok.*;

import java.time.LocalDateTime;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CartResponse {

    public CartResponse (Cart cart){
        this.id=cart.getId();
        this.createdAt=cart.getCreatedAt();
        this.userId = cart.getUserId();
    }

    private Long id;
    private Long userId;
    private LocalDateTime createdAt;


}
