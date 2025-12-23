package com.example.online.thrift.store.controller;

import com.example.online.thrift.store.dto.request.ProductRequest;
import com.example.online.thrift.store.dto.response.ProductResponse;
import com.example.online.thrift.store.service.ProductService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ProductController {

    private final ProductService productService;

    @PostMapping("/product")

    public ResponseEntity<?> addProduct(@RequestPart ProductRequest productRequest, @RequestPart MultipartFile imageFile)throws Exception{

        productService.saveProduct(productRequest,imageFile);


        return BaseController.successResponse("Product Saved Successfully","{ }");
    }

    @GetMapping("/products")

    public ResponseEntity<?> getAllProduct(){

        List<ProductResponse> productList = productService.getAllProduct();

        return BaseController.successResponse("All Product Details:",productList);
    }

    @GetMapping("/product/{id}")

    public ResponseEntity<?> getProductById(@PathVariable Long id){

        ProductResponse productResponse = productService.getSingleProduct(id);
        return BaseController.successResponse("Product with id "+id+" found Successfully",productResponse);
    }


    @DeleteMapping("/delete-product/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id){

        productService.deleteProduct(id);
        return BaseController.successResponse("Product Deleted SuccessFully","{ }");

    }

}
