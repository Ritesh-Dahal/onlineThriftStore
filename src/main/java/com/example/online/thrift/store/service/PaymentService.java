package com.example.online.thrift.store.service;

import com.example.online.thrift.store.dto.request.PaymentRequest;
import com.example.online.thrift.store.entity.OrderItem;
import com.example.online.thrift.store.entity.Payment;
import com.example.online.thrift.store.entity.Product;
import com.example.online.thrift.store.repository.OrderItemRepository;
import com.example.online.thrift.store.repository.PaymentRepository;
import com.example.online.thrift.store.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final OrderItemRepository orderItemRepository;
    private final ProductRepository productRepository;

    public Payment addPayment(PaymentRequest paymentRequest){
        Payment payment = new Payment(paymentRequest);
       return paymentRepository.save(payment);
    }


    public List<Double> getAllPaymentForAnalysis(){

        List<Payment> allPaymentList = paymentRepository.findAll();

        return allPaymentList.stream().map(payment -> payment.getAmount()).toList();

    }

    public  Payment getPaymentById(Long id){

        return paymentRepository.findById(id).get();
    }






}
