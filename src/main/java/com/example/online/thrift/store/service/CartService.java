package com.example.online.thrift.store.service;

import com.example.online.thrift.store.dto.request.CartRequest;
import com.example.online.thrift.store.dto.response.CartResponse;
import com.example.online.thrift.store.entity.Cart;
import com.example.online.thrift.store.exception.NotFoundException;
import com.example.online.thrift.store.repository.CartRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartRepository cartRepository;
    private  final ObjectMapper objectMapper;

    public Map<String,Object> createCart(CartRequest cartRequest){

       Optional<Cart> cart = cartRepository.findByUserId(cartRequest.getUserId());
       if(cart.isPresent()){
           return objectMapper.convertValue(cart, new TypeReference<Map<String, Object>>() {
           });

       } else {
           Cart newCart = new Cart(cartRequest);
           cartRepository.save(newCart);
           Cart cart1 = cartRepository.findByUserId(cartRequest.getUserId()).get();
           return objectMapper.convertValue(cart1, new TypeReference<Map<String, Object>>() {
           });

       }
    }

    public CartResponse getCartByUserId(Long id){

       Cart cart = cartRepository.findByUserId(id)
               .orElseThrow(()-> new NotFoundException("Cart With Provided User Id Not Found"));

       CartResponse cartResponse = new CartResponse(cart);
       return cartResponse;
    }

    public void deleteCartByUserId(Long id){

        cartRepository.findByUserId(id)
                .orElseThrow(()-> new NotFoundException("Cart With Provided Id Not Found"));
        cartRepository.deleteById(id);

    }


}
