package com.prueba.warehouse.controller.dto;

public class ArticleDto {
    private int art_id;

    private String name;

    private int stock;

    public ArticleDto(int art_id, String name, int stock) {
        this.art_id = art_id;
        this.name = name;
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "{art_id=" + art_id +
                ", name='" + name + '\'' +
                ", stock=" + stock +
                '}';
    }

    public ArticleDto() {

    }

    public int getArt_id() {
        return art_id;
    }

    public void setArt_id(int art_id) {
        this.art_id = art_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
