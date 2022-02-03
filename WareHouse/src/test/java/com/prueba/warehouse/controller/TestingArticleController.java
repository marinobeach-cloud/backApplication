package com.prueba.warehouse.controller;

import com.google.gson.Gson;
import com.prueba.warehouse.controller.dto.ArticleDto;
import com.prueba.warehouse.service.ArticleService;
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

@WebMvcTest(ArticleController.class)
public class TestingArticleController {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ArticleService articleService;

    @Test
    public void callingArticlesShouldReturnArticles() throws Exception {
        List<ArticleDto> articleDtoList = new ArrayList<>();
        ArticleDto articleDto = new ArticleDto(1, "hola", 2);
        articleDtoList.add(articleDto);

        Gson gson = new Gson();

        when(articleService.getArticles()).thenReturn(articleDtoList);

        this.mockMvc.perform(get("/articles")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString(gson.toJson(articleDtoList))));
    }
}
