package com.github.w4o.boot.service;

import com.github.w4o.boot.domain.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.math.BigDecimal;

@SpringBootTest
class ProductServiceTest {

    @Resource
    private ProductService productService;

    @Test
    void getProductById() {
        
        Product product = productService.getProductById(1);

        Assertions.assertNotNull(product);
        Assertions.assertEquals("海参炒面", product.getName());
        Assertions.assertEquals(false, product.getDeleted());
        Assertions.assertEquals("A0001", product.getCode());
        Assertions.assertEquals(new BigDecimal("20.00"), product.getPrice());
    }

    @Test
    void addProduct() {
    }

    @Test
    void modifyProduct() {
    }

    @Test
    void removeProductById() {
    }
}