package org.example.hwshoppingmall.dto;

import lombok.Data;

import java.util.List;

@Data
public class CreateOrderRequest {
    private List<BuyItem> buyItemList;
}
