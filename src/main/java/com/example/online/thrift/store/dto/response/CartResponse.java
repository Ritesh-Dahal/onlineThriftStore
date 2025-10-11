package com.example.online.thrift.store.dto.response;

import lombok.*;

import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter

public class CartResponse {
    private Long id;
    private LocalDateTime createdAt;

    private Long userId;
}
