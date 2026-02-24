package com.example.online.thrift.store.service;


import com.example.online.thrift.store.entity.Product;
import com.example.online.thrift.store.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SellerService {

    private final ProductRepository productRepository;


    public List<Product> getAllProduct(Long id){

        List<Product> allProduct = productRepository.findAllProductByUserId(id);
        return allProduct;
    }






}
