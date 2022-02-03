package com.prueba.warehouse.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "Article")
public class Article {

    @Id
    @Column(name = "art_id")
    private int art_id;

    @Column(name = "name")
    private String name;

    @Column(name = "stock")
    private int stock;

    public Article(int art_id, String name, int stock) {
        this.art_id = art_id;
        this.name = name;
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "{" +
                "art_id=" + art_id +
                ", name='" + name + '\'' +
                ", stock=" + stock +
                '}';
    }

    public Article() {

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
