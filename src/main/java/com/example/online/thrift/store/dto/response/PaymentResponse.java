package com.example.online.thrift.store.dto.response;

import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class PaymentResponse {

    private Long id;
    private LocalDateTime paymentDate;
    private Double amount;
    private String paymentMethod;
    private String Status;
    private Long orderId;
}
