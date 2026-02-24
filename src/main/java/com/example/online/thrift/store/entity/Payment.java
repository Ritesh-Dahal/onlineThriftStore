package com.example.online.thrift.store.entity;

import com.example.online.thrift.store.dto.request.PaymentRequest;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime paymentDate;
    private Double amount;
    private String paymentMethod;
    private String status;

    private Long orderId;

    public Payment (PaymentRequest paymentRequest){
        this.paymentDate = paymentRequest.getPaymentDate();
        this.amount = paymentRequest.getAmount();
        this.paymentMethod = paymentRequest.getPaymentMethod();
        this.status = paymentRequest.getStatus();
        this.orderId = paymentRequest.getOrderId();

    }

}
