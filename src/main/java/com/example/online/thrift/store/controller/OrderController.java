package com.example.online.thrift.store.controller;

import com.example.online.thrift.store.dto.response.OrderItemProductResponse;
import com.example.online.thrift.store.dto.response.OrderProductResponse;
import com.example.online.thrift.store.dto.response.UserResponse;
import com.example.online.thrift.store.entity.Order;
import com.example.online.thrift.store.entity.OrderItem;
import com.example.online.thrift.store.entity.Product;
import com.example.online.thrift.store.entity.Users;
import com.example.online.thrift.store.enums.Status;
import com.example.online.thrift.store.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController extends BaseController {

    private final OrderService orderService;

    @PostMapping("/place/{userId}")
    public Order placeOrder(@PathVariable Long userId) {
        return orderService.placeOrder(userId);
    }

    @GetMapping("/user/{userId}")
    public List<OrderItemProductResponse> getOrdersByUser(@PathVariable Long userId) {
        return orderService.getOrdersByUserId(userId);
    }

    @GetMapping("/{sellerId}")

    public List<OrderProductResponse> getOrderedItem(@PathVariable Long sellerId){
        return orderService.getOrderedList(sellerId);
    }

    @PutMapping("/change-status/{orderId}")
    public void changeOrderStatus(@PathVariable Long orderId,@RequestParam Long productId,@RequestBody Map<String,String> status){
        orderService.changeOrderStatus(orderId,productId,status.get("status"));
    }


    @GetMapping("/admin")

    public List<UserResponse> getTopFiveCustomers(){

        return orderService.getTop5UsersWithMaxOrders();

    }

}
