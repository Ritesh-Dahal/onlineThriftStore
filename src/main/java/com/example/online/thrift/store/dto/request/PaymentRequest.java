package com.example.online.thrift.store.dto.request;

import lombok.*;

import java.time.LocalDateTime;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class PaymentRequest {
    private LocalDateTime paymentDate;
    private Double amount;
    private String paymentMethod;
    private String status;
    private Long orderId;
}
