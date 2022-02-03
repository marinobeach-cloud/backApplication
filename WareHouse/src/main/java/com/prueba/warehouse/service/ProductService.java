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
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ProductService {
    public ProductService(ArticleRepository articleRepository, Mapper mapper, ProductRepository productRepository, ProdArtRepository productArtRepository) {
        this.articleRepository = articleRepository;
        this.mapper = mapper;
        this.productArtRepository = productArtRepository;
        this.productRepository = productRepository;
    }

    private ArticleRepository articleRepository;

    private ProductRepository productRepository;

    private ProdArtRepository productArtRepository;

    private Mapper mapper;

    public List<ProductDto> getProducts() {
        List<ProductDto> productDtoList = new ArrayList<>();

        List<Product> products = productRepository.findAll();
        for (Product product: products) {
            List<ProdArt> prodsArts = productArtRepository.findAllByProdId(product.getProd_id());
            List<ContainArticleDto> articleDtoList = new ArrayList<>();

            for (ProdArt prodArt: prodsArts) {
                Article article = articleRepository.findAllById(Collections.singleton(prodArt.getArt_id())).get(0);
                ContainArticleDto containArticleDto = mapper.getArticleToArticleResponse(article, prodArt);

                articleDtoList.add(containArticleDto);
            }

            ProductDto productDto = mapper.getProductAndListProdArticlesToProductResponse(product, articleDtoList);
            productDtoList.add(productDto);
        }

        return productDtoList;
    }

    public ProductDto sellProduct(String productName) {
        Product product = productRepository.findByName(productName);
        List<ProdArt> prodsArts = productArtRepository.findAllByProdId(product.getProd_id());
        List<ContainArticleDto> articleDtoList = new ArrayList<>();

        for (ProdArt prodArt: prodsArts) {
            Article article = articleRepository.findAllById(Collections.singleton(prodArt.getArt_id())).get(0);
            int articleStock = article.getStock();
            int amountOf = prodArt.getAmount_of();

            if (articleStock >= amountOf) {
                int newStock = articleStock - amountOf;
                articleRepository.updateArticle(newStock, article.getArt_id());

                article.setStock(newStock);
                ContainArticleDto containArticleDto = mapper.getArticleToArticleResponse(article, prodArt);
                articleDtoList.add(containArticleDto);
            }
            else {
                return null;
            }

        }

        return mapper.getProductAndListProdArticlesToProductResponse(product, articleDtoList);

    }
}
