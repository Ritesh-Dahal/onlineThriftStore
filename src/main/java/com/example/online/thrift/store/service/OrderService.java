package com.example.online.thrift.store.service;

import com.example.online.thrift.store.entity.*;
import com.example.online.thrift.store.enums.Status;
import com.example.online.thrift.store.exception.NotFoundException;
import com.example.online.thrift.store.repository.CartItemRepository;
import com.example.online.thrift.store.repository.OrderItemRepository;
import com.example.online.thrift.store.repository.OrderRepository;
import com.example.online.thrift.store.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final CartItemRepository cartItemRepository;
    private final ProductRepository productRepository;

    public Order placeOrder(Long userId) {

        List<CartItem> cartItems = cartItemRepository.findAllByUserId(userId);

        if (cartItems.isEmpty()) {
            throw new NotFoundException("Cart is empty");
        }

        Order order = new Order();
        order.setUserId(userId);
        order.setStatus(Status.PENDING);
        order.setCreatedAt(LocalDateTime.now());

        double total = 0;

        order = orderRepository.save(order);

        for (CartItem cartItem : cartItems) {

            Product product = productRepository.findById(cartItem.getProductId())
                    .orElseThrow(() -> new NotFoundException("Product not found"));

            OrderItem orderItem = new OrderItem();
            orderItem.setOrderId(order.getId());
            orderItem.setProductId(product.getId());
            orderItem.setQuantity(cartItem.getQuantity());
            orderItem.setPrice(product.getPrice());

            total += product.getPrice() * cartItem.getQuantity();

            orderItemRepository.save(orderItem);
        }

        order.setTotalAmount(total);
        orderRepository.save(order);


        cartItemRepository.deleteAll(cartItems);

        return order;
    }

    public List<Order> getOrdersByUserId(Long userId) {
        return orderRepository.findByUserId(userId);
    }
}
