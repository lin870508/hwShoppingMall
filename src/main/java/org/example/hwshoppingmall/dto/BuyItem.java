package org.example.hwshoppingmall.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class BuyItem {


    @NotNull
    private String productId;

    @NotNull
    private Integer quantity;
}
