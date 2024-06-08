package org.example.hwshoppingmall.service;

import org.example.hwshoppingmall.dto.CreateOrderRequest;
import org.example.hwshoppingmall.model.Order;
import org.example.hwshoppingmall.model.OrderDetail;

import java.util.List;

public interface OrderService {


    String createOrder(Integer memberId, CreateOrderRequest createOrderRequest);

    void insertOrderDetails(List<OrderDetail> orderDetailList);

    Order getOrderById(String orderId);

}
