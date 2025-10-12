package com.example.online.thrift.store.dto.response;


import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductResponse {

    private Long id;

    private String name;
    private String description;
    private Double price;
    private Long quantity;
    private Long categoryId;
    private Long userId;
}
