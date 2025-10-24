package com.example.online.thrift.store.dto.response;


import com.example.online.thrift.store.entity.Product;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductResponse {

    public ProductResponse(Product product){

        this.id = product.getId();
        this.categoryId = product.getCategoryId();
        this.name=product.getName();
        this.userId=product.getUserId();
        this.description= product.getDescription();
        this.price= product.getPrice();
        this.quantity= product.getQuantity();
        this.imagePath = product.getImagePath();

    }




    private Long id;
    private Long userId;
    private Long categoryId;

    private String name;
    private String description;
    private Double price;
    private Long quantity;
    private String imagePath;

}
