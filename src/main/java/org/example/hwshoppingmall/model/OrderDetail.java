package org.example.hwshoppingmall.model;

import lombok.Data;

@Data
public class OrderDetail {
    private Integer orderItemSN; //訂單明細流水號
    private Integer orderId; //訂單編號
    private Integer productId; //商品編號
    private Integer quantity; //數量
    private Integer standPrice; //單價
    private Integer itemPrice; //單品項總價
}
