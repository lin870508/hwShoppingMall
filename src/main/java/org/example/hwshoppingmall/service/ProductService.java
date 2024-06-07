package org.example.hwshoppingmall.service;

import org.example.hwshoppingmall.model.Product;

public interface ProductService {
    Product getProductById(String productId);

    Product createProduct(Product product);

}
