package com.prueba.warehouse.repository;

import com.prueba.warehouse.repository.entity.Product;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class TestingProductRepository {

    @Autowired
    private ProductRepository productRepository;

    @Test
    public void getProduct() {

        Product product = productRepository.findByName("Mesa");
        assertEquals(product.getName(), "Mesa");
    }
}
