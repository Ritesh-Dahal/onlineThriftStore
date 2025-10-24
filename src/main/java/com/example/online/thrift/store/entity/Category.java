package com.example.online.thrift.store.entity;

import com.example.online.thrift.store.dto.request.CartRequest;
import com.example.online.thrift.store.dto.request.CategoryRequest;
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
public class Category {

    public Category (CategoryRequest categoryRequest){
        this.name = categoryRequest.getName();
        this.description = categoryRequest.getDescription();
    }



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;

}
