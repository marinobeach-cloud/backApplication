package com.prueba.warehouse.repository;

import com.prueba.warehouse.repository.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Integer> {
    @Query("UPDATE Article a set a.stock = ?1 WHERE a.art_id = ?2")
    @Modifying
    @Transactional
    void updateArticle(int newStock, int artId);
}
