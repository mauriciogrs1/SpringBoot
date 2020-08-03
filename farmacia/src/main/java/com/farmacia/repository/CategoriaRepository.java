package com.farmacia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.farmacia.model.CategoriaModel;


public interface CategoriaRepository extends JpaRepository<CategoriaModel, Long> {

}
