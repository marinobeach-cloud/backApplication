package com.prueba.warehouse.repository;

import com.prueba.warehouse.repository.entity.ProdArt;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class TestingProdArtRepository {

    @Autowired
    private ProdArtRepository prodArtRepository;

    @Test
    public void prodArt() {
        int prodId = 1;

        List<ProdArt> prodArts = prodArtRepository.findAllByProdId(prodId);
        assertEquals(prodArts.get(0).getProd_id(), prodId);
    }
}
