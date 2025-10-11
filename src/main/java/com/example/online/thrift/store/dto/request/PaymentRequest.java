package com.example.online.thrift.store.dto.request;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter

public class PaymentRequest {
    private LocalDateTime paymentDate;
    private Double amount;
    private String paymentMethod;
    private String Status;
    private Long orderId;
}
