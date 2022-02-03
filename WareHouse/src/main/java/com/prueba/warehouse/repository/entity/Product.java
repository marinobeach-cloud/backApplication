package com.prueba.warehouse.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "Product")
public class Product {

    public Product(int prod_id, String name) {
        this.prod_id = prod_id;
        this.name = name;
    }

    public Product() {

    }

    @Id
    @Column(name = "prod_id")
    private int prod_id;

    @Column(name = "name")
    private String name;

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
}
