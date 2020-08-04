package com.redesocial.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.redesocial.model.Postagem;

public interface PostagemRepository extends JpaRepository<Postagem, Long> {

}
