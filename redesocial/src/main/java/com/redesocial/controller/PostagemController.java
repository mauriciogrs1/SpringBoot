package com.redesocial.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.redesocial.model.Postagem;
import com.redesocial.repository.PostagemRepository;

@RestController
@RequestMapping ("/postagem")
@CrossOrigin ("*")
public class PostagemController {
	
	@Autowired
	private PostagemRepository repository;

	@GetMapping
	public ResponseEntity <List<Postagem>> ListarPostagem (){
			return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Postagem> ListarPostagemPorId(@PathVariable long id) {
		return repository.findById(id) .map(resp -> ResponseEntity.ok(resp)). orElse (ResponseEntity.notFound() .build());
	}
		
	@PostMapping
	public ResponseEntity<Postagem> incluirPostagem(@RequestBody Postagem postagem) {
			return ResponseEntity.status(HttpStatus.CREATED) .body(repository.save (postagem));
	}
	@PutMapping
	public ResponseEntity<Postagem> atualizarPostagem(@RequestBody Postagem postagem) {
			return ResponseEntity.status(HttpStatus.OK) .body(repository.save (postagem));
	}
	@DeleteMapping("/{id}")
	public void deletarPostagem(@PathVariable long id) {
			repository.deleteById(id);
	}

}
