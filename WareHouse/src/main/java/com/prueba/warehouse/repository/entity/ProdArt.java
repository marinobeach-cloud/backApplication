package com.prueba.warehouse.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "Prod_Art")
public class ProdArt {

    public ProdArt(int art_id, int prod_id, int amount_of) {
        this.art_id = art_id;
        this.prod_id = prod_id;
        this.amount_of = amount_of;
    }

    public ProdArt() {

    }

    public int getArt_id() {
        return art_id;
    }

    public void setArt_id(int art_id) {
        this.art_id = art_id;
    }

    public int getProd_id() {
        return prod_id;
    }

    public void setProd_id(int prod_id) {
        this.prod_id = prod_id;
    }

    public int getAmount_of() {
        return amount_of;
    }

    public void setAmount_of(int amount_of) {
        this.amount_of = amount_of;
    }

    @Id
    @Column(name = "art_id")
    private int art_id;

    @Column(name = "prod_id")
    private int prod_id;

    @Column(name = "amount_of")
    private int amount_of;
}
