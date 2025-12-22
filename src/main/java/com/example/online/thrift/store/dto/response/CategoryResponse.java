package com.example.online.thrift.store.dto.response;

import com.example.online.thrift.store.entity.Category;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CategoryResponse {

    public CategoryResponse(Category category){
        this.id = category.getId();
        this.name = category.getName();

    }

    private Long id;
    private String name;

}
