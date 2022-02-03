package com.prueba.warehouse.repository;

import com.prueba.warehouse.repository.entity.Article;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class TestingArticleRepository {

    @Autowired
    private ArticleRepository articleRepository;

    @Test
    public void updateArticle() {
        int newStock = 3;
        int artId = 1;

        articleRepository.updateArticle(newStock, artId);
        List<Article> article = articleRepository.findAllById(Collections.singleton(artId));

        assertEquals(article.get(0).getStock(), newStock);
    }
}
