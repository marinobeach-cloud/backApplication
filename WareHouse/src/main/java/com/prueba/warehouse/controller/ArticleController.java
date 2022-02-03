package com.prueba.warehouse.controller;

import com.prueba.warehouse.controller.dto.ArticleDto;
import com.prueba.warehouse.service.ArticleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ArticleController {

    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    private ArticleService articleService;

    @GetMapping("/articles")
    public ResponseEntity<List<ArticleDto>> getArticles() {
        return new ResponseEntity<>(articleService.getArticles(), HttpStatus.OK);
    }
}
