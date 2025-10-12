package com.example.online.thrift.store.dto.response;

import lombok.*;

import java.time.LocalDateTime;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CartResponse {
    private Long id;
    private LocalDateTime createdAt;

    private Long userId;
}
