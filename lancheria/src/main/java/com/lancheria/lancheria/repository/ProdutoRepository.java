package com.lancheria.lancheria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lancheria.lancheria.entities.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {

}