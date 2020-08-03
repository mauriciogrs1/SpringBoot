package com.farmacia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.farmacia.model.ProdutoModel;

public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long> {

}
