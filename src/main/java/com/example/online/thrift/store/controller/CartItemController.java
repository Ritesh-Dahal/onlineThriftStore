package com.example.online.thrift.store.controller;


import com.example.online.thrift.store.dto.request.CartItemRequest;
import com.example.online.thrift.store.service.CartItemService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CartItemController extends BaseController {
    private final CartItemService cartItemService;


    @PostMapping("/add-cart")

    public ResponseEntity<?> addToCart(@RequestBody CartItemRequest cartItemRequest){

        cartItemService.addToCart(cartItemRequest);

        return successResponse("Item Successfully Added On Cart", "{ }");

    }

    @GetMapping("/cart-item/{id}")

    public ResponseEntity<?> getItemFromCartByUserId(@PathVariable Long id){

        return successResponse("Item Successfully Added On Cart", cartItemService.getCartItemByUserId(id));

    }

    @Transactional
    @DeleteMapping("/cart/item/{productId}")
    public ResponseEntity<?> removeItemFromCart(@PathVariable Long productId){

        cartItemService.removeItemFromCart(productId);

        return successResponse("Item Removed Successfully", "{}");

    }


}
