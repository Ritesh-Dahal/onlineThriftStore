package com.example.online.thrift.store.dto.request;

import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CategoryRequest {
    private String name;
    private String description;
}
