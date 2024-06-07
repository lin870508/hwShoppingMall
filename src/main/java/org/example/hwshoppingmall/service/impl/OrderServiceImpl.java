package org.example.hwshoppingmall.service.impl;

import org.example.hwshoppingmall.dao.OrderDao;
import org.example.hwshoppingmall.dao.ProductDao;
import org.example.hwshoppingmall.dto.BuyItem;
import org.example.hwshoppingmall.model.Order;
import org.example.hwshoppingmall.model.OrderDetail;
import org.example.hwshoppingmall.model.Product;
import org.example.hwshoppingmall.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderServiceImpl implements OrderService {

    private final static Logger log = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private ProductDao productDao;


    @Override
    public Integer createOrder(Integer memberId, Order order) {
        int totalAmount = 0;
        List<OrderDetail> orderDetailList = new ArrayList<>();

        for (BuyItem buyItem : createOrderRequest.getBuyItemList()) {
            Product product = productDao.getProductById(buyItem.getProductId());

            // 檢查 product 是否存在、庫存是否足夠
            if (product == null) {
                log.warn("商品 {} 不存在", buyItem.getProductId());
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST);

            } else if (product.getStock() < buyItem.getQuantity()) {
                log.warn("商品 {} 庫存數量不足，無法購買。剩餘庫存 {}，欲購買數量 {}",
                        buyItem.getProductId(), product.getStock(), buyItem.getQuantity());
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
            }



    }
        return 0;
    }
}
