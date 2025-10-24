package com.example.online.thrift.store.entity;

import com.example.online.thrift.store.dto.request.CartRequest;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Cart {

    public Cart(CartRequest cartRequest){
        this.createdAt=cartRequest.getCreatedAt();
        this.userId=cartRequest.getUserId();
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime createdAt;

    private Long userId;


}
