package org.example.hwshoppingmall.service;

import org.example.hwshoppingmall.model.Order;

public interface OrderService {


    Integer createOrder(Integer memberId,Order order);
}
