package com.example.online.thrift.store.dto.request;

import com.example.online.thrift.store.enums.Status;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class OrderRequest {
    private LocalDateTime orderDate;
    private Status status;
    private Double totalAmount;
    private Long userId;
}
