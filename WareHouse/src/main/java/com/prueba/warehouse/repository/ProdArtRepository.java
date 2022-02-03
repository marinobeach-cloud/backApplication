package com.prueba.warehouse.repository;

import com.prueba.warehouse.repository.entity.ProdArt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdArtRepository extends JpaRepository<ProdArt, Integer> {
    @Query("SELECT p FROM Prod_Art p WHERE p.prod_id = ?1")
    List<ProdArt> findAllByProdId(int prod_id);
}
