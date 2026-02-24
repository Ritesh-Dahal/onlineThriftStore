package com.example.online.thrift.store.service;

import com.example.online.thrift.store.dto.response.OrderItemProductResponse;
import com.example.online.thrift.store.dto.response.OrderProductResponse;
import com.example.online.thrift.store.dto.response.UserResponse;
import com.example.online.thrift.store.entity.*;
import com.example.online.thrift.store.enums.Status;
import com.example.online.thrift.store.exception.NotFoundException;
import com.example.online.thrift.store.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.config.core.userdetails.UserDetailsResourceFactoryBean;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;
    private final CartItemRepository cartItemRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

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
            orderItem.setStatus(Status.PENDING);

            total += product.getPrice() * cartItem.getQuantity();

            orderItemRepository.save(orderItem);
        }

        order.setTotalAmount(total);
        orderRepository.save(order);


        cartItemRepository.deleteAll(cartItems);

        return order;
    }

    public List<OrderItemProductResponse> getOrdersByUserId(Long userId) {


            List<Order> orders = orderRepository.findByUserId(userId);

            if (orders.isEmpty()) {
                return List.of();
            }


            List<Long> orderIds = orders.stream()
                    .map(Order::getId)
                    .toList();


            List<OrderItem> orderItems =
                    orderItemRepository.findByOrderIdIn(orderIds);

            if (orderItems.isEmpty()) {
                return List.of();
            }


            Set<Long> productIds = orderItems.stream()
                    .map(OrderItem::getProductId)
                    .collect(Collectors.toSet());


            Map<Long, Product> productMap =
                    productRepository.findAllById(productIds)
                            .stream()
                            .collect(Collectors.toMap(Product::getId, p -> p));


            return orderItems.stream()
                    .map(item -> new OrderItemProductResponse(
                            item,
                            productMap.get(item.getProductId())
                    ))
                    .toList();





    }

    public List<OrderProductResponse> getOrderedList(Long sellerId) {

        List<OrderItem> orderItems = orderItemRepository.findAll();
        List<Product> productList = productRepository.findAllProductByUserId(sellerId);



        Set<Long> productIds =
                productList.stream()
                        .map(Product::getId)
                        .collect(Collectors.toSet());

        Map<Long, Product> productMap =
                productList.stream()
                        .collect(Collectors.toMap(Product::getId, p -> p));

        return orderItems.stream()
                .filter(orderItem -> productMap.containsKey(orderItem.getProductId()))
                .map(orderItem ->
                        new OrderProductResponse(
                                orderItem,
                                productMap.get(orderItem.getProductId())
                        )
                )
                .toList();

    }

    public void changeOrderStatus(Long orderId, Long productId, String status) {

        List<OrderItem> items = orderItemRepository.findByOrderId(orderId);

        items.stream()
                .filter(item -> item.getProductId().equals(productId))
                .forEach(item -> item.setStatus(Status.valueOf(status)));

        orderItemRepository.saveAll(items);
    }


    public List<UserResponse> getTop5UsersWithMaxOrders() {

       List<Long> topUserIds = orderRepository.findTopUserIds(
                PageRequest.of(0, 5)
        );

        Map<Long, Integer> orderMap = new HashMap<>();
        for (int i = 0; i < topUserIds.size(); i++) {
            orderMap.put(topUserIds.get(i), i);
        }

        List<Users> users = userRepository.findByIdIn(topUserIds);

        users.sort(Comparator.comparingInt(u -> orderMap.get(u.getId())));

        return  users.stream().map(UserResponse::new).toList();
   }

    public List<Product> getProductByOrderId(Long orderId) {

        List<OrderItem> orderItems = orderItemRepository.findByOrderId(orderId);

        return orderItems.stream()
                .map(item -> productRepository
                        .findById(item.getProductId())
                        .orElseThrow(() -> new RuntimeException("Product not found")))
                .toList();
    }






}
