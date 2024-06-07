package org.example.hwshoppingmall.model;

import lombok.Data;

@Data
public class Order {
    private Integer orderId; //訂單編號
    private Integer memberId; //會員編號
    private Integer price; //訂單金額
    private Integer payStatus;  //付款狀態(0 未付款/1已付款)
}
