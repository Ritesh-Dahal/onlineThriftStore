package com.example.online.thrift.store.controller;

import com.example.online.thrift.store.dto.request.CartRequest;
import com.example.online.thrift.store.dto.response.CartResponse;
import com.example.online.thrift.store.service.CartService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class CartController {

    private CartService cartService;

    @PostMapping("/cart")
    public ResponseEntity<?> createCart(@RequestBody CartRequest cartRequest){
        cartService.createCart(cartRequest);
        return BaseController.successResponse("Cart Created Successfully", HttpStatus.OK);

    }

    @GetMapping("/cart")

    public ResponseEntity<?> getCartByUserId(@PathVariable Long id){

       CartResponse response = cartService.getCartByUserId(id);

        return BaseController.successResponse("Cart With User id",response);

    }

    @DeleteMapping("/cart")

    public ResponseEntity<?> deleteCartByUserId(Long id){

        cartService.deleteCartByUserId(id);
        return BaseController.successResponse("Cart Deleted Successfully","{ }");

    }

}
