package org.example.hwshoppingmall.model;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Product {
    @TableId
    private String productId; //商品編號
    private String productName; //商品名稱
    private Integer price; //售價
    private Integer quantity;//庫存
}
