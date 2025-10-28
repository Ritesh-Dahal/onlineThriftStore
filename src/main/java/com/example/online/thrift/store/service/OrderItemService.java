package com.example.online.thrift.store.service;

import com.example.online.thrift.store.dto.request.OrderItemRequest;
import com.example.online.thrift.store.dto.response.OrderItemResponse;
import com.example.online.thrift.store.entity.OrderItem;
import com.example.online.thrift.store.exception.NotFoundException;
import com.example.online.thrift.store.repository.OrderItemRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OrderItemService {
    private OrderItemRepository orderItemRepository;

    public void saveOrder(OrderItemRequest orderItemRequest){

        OrderItem orderItem = new OrderItem(orderItemRequest);
        orderItemRepository.save(orderItem);

    }

    public OrderItemResponse getOrderByUserId(Long id ){

        OrderItem orderItem = orderItemRepository.findByUserId(id)
                .orElseThrow(()-> new NotFoundException("User With Provided Id Not Found"));
        return new OrderItemResponse(orderItem);

    }

    public List<OrderItemResponse> getAllOrdersItems(){
        List<OrderItem> orderItemList = orderItemRepository.findAll();
        List<OrderItemResponse> responseList = orderItemList.stream().map(OrderItemResponse::new).toList();
        return responseList;

    }


}
