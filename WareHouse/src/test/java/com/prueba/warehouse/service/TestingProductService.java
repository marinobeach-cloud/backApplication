package com.prueba.warehouse.service;

import com.prueba.warehouse.controller.dto.ContainArticleDto;
import com.prueba.warehouse.controller.dto.ProductDto;
import com.prueba.warehouse.repository.ArticleRepository;
import com.prueba.warehouse.repository.ProdArtRepository;
import com.prueba.warehouse.repository.ProductRepository;
import com.prueba.warehouse.repository.entity.Article;
import com.prueba.warehouse.repository.entity.ProdArt;
import com.prueba.warehouse.repository.entity.Product;
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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class TestingProductService {

    @Spy
    private ArticleRepository articleRepository;

    @Spy
    private ProductRepository productRepository;

    @Spy
    private ProdArtRepository prodArtRepository;

    @Spy
    private Mapper mapper;

    @InjectMocks
    private ProductService productService;

    @Test
    public void ArticleServiceShouldReturnArticleRepository() {
        List<Product> productList = new ArrayList<>();
        Product product = new Product(1, "hola");
        productList.add(product);

        List<ProdArt> prodsArts = new ArrayList<>();
        ProdArt prodArt = new ProdArt(1,1,1);
        prodsArts.add(prodArt);

        List<Article> articles = new ArrayList<>();
        Article article = new Article(1, "hola", 1);
        articles.add(article);

        List<ContainArticleDto> contain_articles = new ArrayList<>();
        ContainArticleDto containArticleDto = new ContainArticleDto(article.getArt_id(), article.getName(), article.getStock(), prodArt.getAmount_of());
        contain_articles.add(containArticleDto);

        List<ProductDto> productDtoList = new ArrayList<>();
        ProductDto productDto = new ProductDto(product.getProd_id(), product.getName(), contain_articles);
        productDtoList.add(productDto);

        doReturn(productList).when(productRepository).findAll();
        doReturn(prodsArts).when(prodArtRepository).findAllByProdId(product.getProd_id());

        doReturn(articles).when(articleRepository).findAllById(any());

        assertEquals(productService.getProducts().toString(), productDtoList.toString());
    }
}
