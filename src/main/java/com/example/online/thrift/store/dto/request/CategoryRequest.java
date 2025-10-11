package com.example.online.thrift.store.dto.request;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class CategoryRequest {
    private String name;
    private String description;
}
