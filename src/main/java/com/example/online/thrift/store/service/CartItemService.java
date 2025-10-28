package com.example.online.thrift.store.service;

import com.example.online.thrift.store.dto.request.CartItemRequest;
import com.example.online.thrift.store.dto.response.CartItemResponse;
import com.example.online.thrift.store.entity.Cart;
import com.example.online.thrift.store.entity.CartItem;
import com.example.online.thrift.store.exception.NotFoundException;
import com.example.online.thrift.store.repository.CartItemRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class CartItemService {

    public CartItemRepository cartItemRepository;

    public void createCartItemRepository(CartItemRequest cartItemRequest){

        CartItem  cartItem = new CartItem(cartItemRequest);
        cartItemRepository.save(cartItem);


    }

    public CartItemResponse getCartItemByUserId(Long id){

             CartItem cartItem = cartItemRepository.findByUserId(id).orElseThrow(()-> new NotFoundException("User Not found"));

             CartItemResponse cartResponse = new CartItemResponse(cartItem);
             return cartResponse;
    }





}
