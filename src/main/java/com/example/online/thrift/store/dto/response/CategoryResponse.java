package com.example.online.thrift.store.dto.response;

import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CategoryResponse {
    private Long id;

    private String name;
    private String description;
}
