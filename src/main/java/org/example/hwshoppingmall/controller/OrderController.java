package org.example.hwshoppingmall.controller;

import org.example.hwshoppingmall.dto.CreateOrderRequest;
import org.example.hwshoppingmall.model.Order;
import org.example.hwshoppingmall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Validated
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/users/{memberID}/orders")
    public ResponseEntity<?> createdOrder(@PathVariable Integer memberID,
                                          @RequestBody @Valid CreateOrderRequest createOrderRequest) {
        String orderId = orderService.createOrder(memberID, createOrderRequest);

        Order order = orderService.getOrderById(orderId);

        return ResponseEntity.status(HttpStatus.CREATED).body(order);

    }
}
