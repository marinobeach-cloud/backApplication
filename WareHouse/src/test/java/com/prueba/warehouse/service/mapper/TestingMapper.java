package com.prueba.warehouse.service.mapper;

import com.prueba.warehouse.controller.dto.ArticleDto;
import com.prueba.warehouse.controller.dto.ContainArticleDto;
import com.prueba.warehouse.controller.dto.ProductDto;
import com.prueba.warehouse.repository.entity.Article;
import com.prueba.warehouse.repository.entity.ProdArt;
import com.prueba.warehouse.repository.entity.Product;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class TestingMapper {

    @Autowired
    private Mapper mapper;

    @Test
    public void getListArticlesToArticleResponseList() {
        List<Article> articles = new ArrayList<>();
        Article article = new Article(1, "hola", 1);
        articles.add(article);

        List<ArticleDto> articlesDto = mapper.getListArticlesToArticleResponseList(articles);

        assertEquals(articlesDto.get(0).toString(), articles.get(0).toString());
    }

    @Test
    public void getProductAndListProdArticlesToProductResponse() {
        Product product = new Product(1, "hola");
        List<ContainArticleDto> listContainArticles = new ArrayList<>();
        ContainArticleDto containArticleDto = new ContainArticleDto(1, "adios", 1, 1);
        listContainArticles.add(containArticleDto);

        ProductDto productDto = mapper.getProductAndListProdArticlesToProductResponse(product, listContainArticles);

        assertEquals(productDto.getProd_id(), product.getProd_id());
        assertEquals(productDto.getName(), product.getName());
        assertEquals(productDto.getContain_articles(), listContainArticles);
    }

    @Test
    public void getArticleToArticleResponse() {
        Article article = new Article(1, "hola", 1);
        ProdArt prodArt = new ProdArt(1, 1, 1);

        ContainArticleDto articleDto = mapper.getArticleToArticleResponse(article, prodArt);

        assertEquals(articleDto.getArt_id(), article.getArt_id());
        assertEquals(articleDto.getAmount_of(), prodArt.getAmount_of());
        assertEquals(articleDto.getName(), article.getName());
    }

}
