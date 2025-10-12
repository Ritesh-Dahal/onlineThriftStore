package com.example.online.thrift.store.dto.request;

import lombok.*;

import java.time.LocalDateTime;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class CartRequest {
    private LocalDateTime createdAt;
    private Long userId;
}
