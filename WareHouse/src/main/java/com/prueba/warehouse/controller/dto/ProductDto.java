package com.prueba.warehouse.controller.dto;

import java.util.List;

public class ProductDto {
    private int prod_id;

    private String name;

    private List<ContainArticleDto> contain_articles;

    @Override
    public String toString() {
        return "ProductDto{" +
                "prod_id=" + prod_id +
                ", name='" + name + '\'' +
                ", contain_articles=" + contain_articles +
                '}';
    }

    public ProductDto(int prod_id, String name, List<ContainArticleDto> contain_articles) {
        this.prod_id = prod_id;
        this.name = name;
        this.contain_articles = contain_articles;
    }

    public ProductDto() {

    }

    public int getProd_id() {
        return prod_id;
    }

    public void setProd_id(int prod_id) {
        this.prod_id = prod_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ContainArticleDto> getContain_articles() {
        return contain_articles;
    }

    public void setContain_articles(List<ContainArticleDto> contain_articles) {
        this.contain_articles = contain_articles;
    }
}
