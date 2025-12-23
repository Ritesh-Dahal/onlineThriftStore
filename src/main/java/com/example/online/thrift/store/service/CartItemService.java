package com.example.online.thrift.store.service;

import com.example.online.thrift.store.dto.request.CartItemRequest;
import com.example.online.thrift.store.dto.response.CartItemResponse;
import com.example.online.thrift.store.entity.Cart;
import com.example.online.thrift.store.entity.CartItem;
import com.example.online.thrift.store.entity.Product;
import com.example.online.thrift.store.exception.NotFoundException;
import com.example.online.thrift.store.repository.CartItemRepository;
import com.example.online.thrift.store.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class CartItemService {

    public final CartItemRepository cartItemRepository;
    public final ProductRepository productRepository;

    public void createCartItemRepository(CartItemRequest cartItemRequest){

        CartItem  cartItem = new CartItem(cartItemRequest);
        cartItemRepository.save(cartItem);
       Product product = productRepository.findById(cartItemRequest.getProductId()).get();
       product.setQuantity(product.getQuantity()-cartItemRequest.getQuantity());
       productRepository.save(product);


    }

    public CartItemResponse getCartItemByUserId(Long id){

             CartItem cartItem = cartItemRepository.findByUserId(id).orElseThrow(()-> new NotFoundException("User Not found"));

             CartItemResponse cartResponse = new CartItemResponse(cartItem);
             return cartResponse;
    }





}
