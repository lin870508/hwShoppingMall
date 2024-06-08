package org.example.hwshoppingmall.service.impl;

import org.example.hwshoppingmall.dao.OrderDao;
import org.example.hwshoppingmall.dao.OrderDetailDao;
import org.example.hwshoppingmall.dao.ProductDao;
import org.example.hwshoppingmall.dto.BuyItem;
import org.example.hwshoppingmall.dto.CreateOrderRequest;
import org.example.hwshoppingmall.model.Order;
import org.example.hwshoppingmall.model.OrderDetail;
import org.example.hwshoppingmall.model.Product;
import org.example.hwshoppingmall.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderServiceImpl implements OrderService {


    @Autowired
    private OrderDao orderDao;

    @Autowired
    private ProductDao productDao;

    private final static Logger log = LoggerFactory.getLogger(OrderServiceImpl.class);
    @Autowired
    private OrderDetailDao orderDetailDao;


    @Transactional
    @Override
    public Integer createOrder(Integer memberId, CreateOrderRequest createOrderRequest) {
        int totalAmount = 0;
        List<OrderDetail> orderDetailList = new ArrayList<>();

        //抓取購物車裡面的每個product的資料
        for (BuyItem buyItem : createOrderRequest.getBuyItemList()) {
            Product product = productDao.selectById(buyItem.getProductId());

            // 檢查 product 是否存在
            if (product == null) {
                log.warn("商品 {} 不存在", buyItem.getProductId());
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
                // 檢查 product 庫存是否足夠
            } else if (product.getQuantity() < buyItem.getQuantity()) {
                log.warn("商品 {} 庫存數量不足，無法購買。剩餘庫存 {}，欲購買數量 {}",
                        buyItem.getProductId(), product.getQuantity(), buyItem.getQuantity());
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
            }

            //更新庫存
            product.setQuantity(product.getQuantity() - buyItem.getQuantity());
            productDao.updateById(product);

            // 計算總價錢
            int amount = buyItem.getQuantity() * product.getPrice();
            totalAmount = totalAmount + amount;

            // 轉換 BuyItem to OrderItem
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setProductId(buyItem.getProductId());
            orderDetail.setQuantity(buyItem.getQuantity());
            orderDetail.setStandPrice(product.getPrice());
            orderDetail.setItemPrice(amount);

            orderDetailList.add(orderDetail);

        }

        // 創建訂單
        Order order = new Order();
        order.setMemberId(memberId);
        order.setPrice(totalAmount);
        order.setPayStatus(0);
        Integer orderId = orderDao.insert(order);

//        orderDetailDao.insertBatch(orderDetailList);

        return orderId;
    }



    @Override
    public Order getOrderById(Integer orderId) {
        Order order=orderDao.selectById(orderId);
        return order;
    }


}
