package org.example.hwshoppingmall.controller;

import org.example.hwshoppingmall.model.Product;
import org.example.hwshoppingmall.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class ProductController {
    private static Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    //    @PostMapping("/products")
//    public ResponseEntity<Product> createProduct(@RequestBody @Valid Product product) {
//        String productId = productService.createProduct(product);
//
//        Product product1 = productService.getProductById(productId);
//
//        return ResponseEntity.status(HttpStatus.CREATED).body(product1);
//    }
    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody @Valid Product product) {
        Product createdProduct = productService.createProduct(product);  // 假设该方法返回完整的 Product 对象
        System.out.println(createdProduct);

        // 检查创建是否成功 (根据实际需求添加)
        if (createdProduct != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(createdProduct);
        } else {
            // 处理创建失败的情况 (例如返回错误信息)
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @GetMapping("/products/{productId}")
    public ResponseEntity<Product> getProduct(@PathVariable String productId) {
        Product product = productService.getProductById(productId);

        if (product != null) {
            return ResponseEntity.status(HttpStatus.OK).body(product);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
