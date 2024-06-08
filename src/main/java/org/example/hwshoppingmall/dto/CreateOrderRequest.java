package org.example.hwshoppingmall.dto;

import lombok.Data;

import java.util.List;

@Data
public class CreateOrderRequest {
    private String orderId;
    private List<BuyItem> buyItemList;
}
