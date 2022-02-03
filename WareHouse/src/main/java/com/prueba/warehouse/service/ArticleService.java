package com.prueba.warehouse.service;

import com.prueba.warehouse.controller.dto.ArticleDto;
import com.prueba.warehouse.repository.ArticleRepository;
import com.prueba.warehouse.repository.entity.Article;
import com.prueba.warehouse.service.mapper.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {

    private ArticleRepository articleRepository;

    private Mapper mapper;

    public ArticleService(ArticleRepository articleRepository, Mapper mapper) {
        this.articleRepository = articleRepository;
        this.mapper = mapper;
    }

    public List<ArticleDto> getArticles() {
        List<Article> articles = articleRepository.findAll();

        return mapper.getListArticlesToArticleResponseList(articles);
    }
}
