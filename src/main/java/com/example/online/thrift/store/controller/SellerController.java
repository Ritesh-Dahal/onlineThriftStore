package com.example.online.thrift.store.controller;

import com.example.online.thrift.store.service.SellerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class SellerController extends BaseController {

    private final SellerService sellerService;
  @GetMapping("/seller/product/{id}")
    public ResponseEntity<?> getAllProductOfUser(@PathVariable Long id){
      return successResponse("Product fetch successfully", sellerService.getAllProduct(id));
  }



}
