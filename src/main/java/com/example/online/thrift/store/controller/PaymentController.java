package com.example.online.thrift.store.controller;

import com.example.online.thrift.store.dto.request.PaymentRequest;
import com.example.online.thrift.store.entity.Payment;
import com.example.online.thrift.store.entity.Product;
import com.example.online.thrift.store.service.OrderService;
import com.example.online.thrift.store.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/payment")
@RequiredArgsConstructor
public class PaymentController extends BaseController {

    private  final PaymentService paymentService;
    private final OrderService orderService;

    @PostMapping("/add-payment")
    @ResponseBody
    public ResponseEntity<?> addPayment(
            @RequestBody PaymentRequest paymentRequest
    ) {
        Payment payment = paymentService.addPayment(paymentRequest);
        return successResponse("Call receipt api using this id ",payment.getId());
    }

    @GetMapping("/receipt/{paymentId}")
    public String receipt(
            @PathVariable Long paymentId,
            Model model
    ) {
        Payment payment = paymentService.getPaymentById(paymentId);

        List<Product> products =
                orderService.getProductByOrderId(payment.getOrderId());

        double totalPrice = products.stream()
                .mapToDouble(Product::getPrice)
                .sum();

        model.addAttribute("storeName", "Neprift");
        model.addAttribute("payment", payment);
        model.addAttribute("products", products);
        model.addAttribute("totalPrice", totalPrice);

        return "receipt";
    }

    @GetMapping("/admin")
    @ResponseBody
    public ResponseEntity<?> getSalesAmount(){
        
        return  successResponse("Sales Amount Fetch Successfully", paymentService.getAllPaymentForAnalysis());
    }



}
