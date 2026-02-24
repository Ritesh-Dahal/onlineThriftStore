package com.example.online.thrift.store.service;

import com.example.online.thrift.store.dto.request.CartItemRequest;
import com.example.online.thrift.store.dto.response.CartItemResponse;
import com.example.online.thrift.store.dto.response.ProductResponse;
import com.example.online.thrift.store.entity.Cart;
import com.example.online.thrift.store.entity.CartItem;
import com.example.online.thrift.store.entity.Product;
import com.example.online.thrift.store.exception.NotFoundException;
import com.example.online.thrift.store.repository.CartItemRepository;
import com.example.online.thrift.store.repository.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class CartItemService {

    public final CartItemRepository cartItemRepository;
    public final ProductRepository productRepository;

    public void addToCart(CartItemRequest cartItemRequest){

        CartItem  cartItem = new CartItem(cartItemRequest);
        cartItemRepository.save(cartItem);
       Product product = productRepository.findById(cartItemRequest.getProductId()).get();
       product.setQuantity(product.getQuantity()-cartItemRequest.getQuantity());
       productRepository.save(product);


    }

    public List<CartItemResponse> getCartItemByUserId(Long id){

             List<CartItem> cartItem = cartItemRepository.findByUserId(id);

        return cartItem.stream()
                .map(item -> {
                    CartItemResponse response = new CartItemResponse();
                    response.setCartId(item.getCartId());
                    response.setQuantity(item.getQuantity());
                    response.setProduct(
                            productRepository.findById(item.getProductId())
                                    .orElseThrow(() -> new RuntimeException("Product not found"))
                    );
                    return response;
                })
                .toList();
    }

    @Transactional
    public void removeItemFromCart(Long productId){

            cartItemRepository.deleteByProductId(productId);

    }






}
