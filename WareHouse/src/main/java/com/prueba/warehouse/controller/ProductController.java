package com.prueba.warehouse.controller;

import com.prueba.warehouse.controller.dto.ProductDto;
import com.prueba.warehouse.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    private ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<List<ProductDto>> getArticles() {
        return new ResponseEntity<>(productService.getProducts(), HttpStatus.OK);
    }

    @DeleteMapping("/products")
    public ResponseEntity<ProductDto> sellProduct(String productName) {

        ProductDto answer = productService.sellProduct(productName);
        if (answer == null)
            return new ResponseEntity<>(null, HttpStatus.NOT_MODIFIED);
        return new ResponseEntity<>(answer, HttpStatus.OK);
    }
}
