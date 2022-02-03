package com.prueba.warehouse.service;

import com.prueba.warehouse.repository.ArticleRepository;
import com.prueba.warehouse.repository.entity.Article;
import com.prueba.warehouse.service.mapper.Mapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class TestingArticleService {

    @Spy
    private ArticleRepository articleRepository;

    @Spy
    private Mapper articleMapping;

    @InjectMocks
    private ArticleService articleService;


    @Test
    public void ArticleServiceShouldReturnArticleRepository() {
        List<Article> articlesList = new ArrayList<>();
        Article article = new Article(1, "hola", 2);
        articlesList.add(article);

        doReturn(articlesList).when(articleRepository).findAll();

        assertEquals(articleService.getArticles().toString(), articleMapping.getListArticlesToArticleResponseList(articlesList).toString());
    }
}
