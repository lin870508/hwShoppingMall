package org.example.hwshoppingmall.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("orderDetail")
@Data
public class OrderDetail {
        @TableId(type = IdType.AUTO)
    private Integer orderItemSN; //訂單明細流水號

    private String orderId; //訂單編號
    private String productId; //商品編號
    private Integer quantity; //數量
    private Integer standPrice; //單價
    private Integer itemPrice; //單品項總價
}
