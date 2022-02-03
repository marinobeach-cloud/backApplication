package com.prueba.warehouse.controller.dto;

public class ContainArticleDto extends ArticleDto{
    @Override
    public String toString() {
        return "ContainArticleDto{" +
                "amount_of=" + amount_of +
                '}';
    }

    private int amount_of;

    public ContainArticleDto(int art_id, String name, int stock, int amount_of) {
        super(art_id, name, stock);
        this.amount_of = amount_of;
    }

    public ContainArticleDto(int amount_of) {
        this.amount_of = amount_of;
    }

    public int getAmount_of() {
        return amount_of;
    }

    public void setAmount_of(int amount_of) {
        this.amount_of = amount_of;
    }
}
