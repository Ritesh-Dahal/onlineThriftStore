package com.example.online.thrift.store.service;

import com.example.online.thrift.store.dto.request.CartRequest;
import com.example.online.thrift.store.dto.response.CartResponse;
import com.example.online.thrift.store.entity.Cart;
import com.example.online.thrift.store.exception.NotFoundException;
import com.example.online.thrift.store.repository.CartRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CartService {

    private CartRepository cartRepository;

    public void createCart(CartRequest cartRequest){

        cartRepository.findByUserId(cartRequest.getUserId());
        Cart cart = new Cart(cartRequest);
        cartRepository.save(cart);

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
