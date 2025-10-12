package com.example.online.thrift.store.dto.response;

import lombok.*;

import java.time.LocalDateTime;


@NoArgsConstructor
@AllArgsConstructor
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
