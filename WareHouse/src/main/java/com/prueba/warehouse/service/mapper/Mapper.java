package com.prueba.warehouse.service.mapper;

import com.prueba.warehouse.controller.dto.ArticleDto;
import com.prueba.warehouse.controller.dto.ContainArticleDto;
import com.prueba.warehouse.controller.dto.ProductDto;
import com.prueba.warehouse.repository.entity.Article;
import com.prueba.warehouse.repository.entity.ProdArt;
import com.prueba.warehouse.repository.entity.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Mapper {

    public List<ArticleDto> getListArticlesToArticleResponseList(List<Article> articles) {

        List<ArticleDto> articleDtoList = new ArrayList<>();
        for (Article article: articles) {
            articleDtoList.add(new ArticleDto(article.getArt_id(), article.getName(), article.getStock()));
        }

        return articleDtoList;
    }

    public ProductDto getProductAndListProdArticlesToProductResponse(Product product, List<ContainArticleDto> articles) {

        ProductDto productDto = new ProductDto();

        productDto.setProd_id(product.getProd_id());
        productDto.setName(product.getName());
        productDto.setContain_articles(articles);

        return productDto;
    }

    public ContainArticleDto getArticleToArticleResponse(Article article, ProdArt prodArt) {
        return new ContainArticleDto(article.getArt_id(), article.getName(), article.getStock(), prodArt.getAmount_of());
    }

}


