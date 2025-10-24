package com.example.online.thrift.store.entity;

import com.example.online.thrift.store.dto.request.ProductRequest;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Product {

    public Product (ProductRequest productRequest){

        this.categoryId = productRequest.getCategoryId();
        this.name=productRequest.getName();
        this.userId=productRequest.getUserId();
        this.description= productRequest.getDescription();
        this.price= productRequest.getPrice();
        this.quantity= productRequest.getQuantity();
    }



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long categoryId;
    private Long userId;

    private String name;
    private String description;
    private Double price;
    private Long quantity;
    private String imagePath;

}
