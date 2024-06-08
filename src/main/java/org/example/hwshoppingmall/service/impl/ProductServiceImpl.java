package org.example.hwshoppingmall.service.impl;

import org.example.hwshoppingmall.dao.ProductDao;
import org.example.hwshoppingmall.model.Product;
import org.example.hwshoppingmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductServiceImpl implements ProductService {

@Autowired
private ProductDao productDao;

    @Override
    public Product getProductById(String productId) {
        return productDao.selectById(productId);
    }

    @Override
    public Product createProduct(Product product) {
        productDao.insert(product);
        return product;
    }
}
