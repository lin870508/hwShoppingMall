package org.example.hwshoppingmall.service;

import org.example.hwshoppingmall.dto.CreateOrderRequest;
import org.example.hwshoppingmall.model.Order;

public interface OrderService {


    Integer createOrder(Integer memberId, CreateOrderRequest createOrderRequest);

    Order getOrderById(Integer orderId);

}
