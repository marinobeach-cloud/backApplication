package com.prueba.warehouse.controller;

import com.google.gson.Gson;
import com.prueba.warehouse.controller.dto.ProductDto;
import com.prueba.warehouse.service.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ProductController.class)
public class TestingProductController {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;

    @Test
    public void callingProductsShouldReturnProducts() throws Exception {
        List<ProductDto> productDtoList = new ArrayList<>();
        ProductDto articleDto = new ProductDto(1, "hola", new ArrayList<>());
        productDtoList.add(articleDto);

        Gson gson = new Gson();

        when(productService.getProducts()).thenReturn(productDtoList);

        this.mockMvc.perform(get("/products")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString(gson.toJson(productDtoList))));

    }
}
