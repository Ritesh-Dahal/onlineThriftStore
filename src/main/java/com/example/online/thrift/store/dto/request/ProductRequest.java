package com.example.online.thrift.store.dto.request;


import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductRequest {
    private Long categoryId;
    private Long userId;
    private String name;
    private String description;
    private Double price;
    private Long quantity;

}
