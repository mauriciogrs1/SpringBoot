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

import com.redesocial.model.Usuario;
import com.redesocial.repository.UsuarioRepository;

@RestController
@RequestMapping ("/usuario")
@CrossOrigin ("*")
public class UsuarioController {
	@Autowired
	private UsuarioRepository repository;

	@GetMapping
	public ResponseEntity <List<Usuario>> ListarUsuario(){
			return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> ListarUsuarioPorId(@PathVariable long id) {
		return repository.findById(id) .map(resp -> ResponseEntity.ok(resp)). orElse (ResponseEntity.notFound() .build());
	}
		
	@PostMapping
	public ResponseEntity<Usuario> incluirUsuario(@RequestBody Usuario usuario) {
			return ResponseEntity.status(HttpStatus.CREATED) .body(repository.save (usuario));
	}
	@PutMapping
	public ResponseEntity<Usuario> atualizarUsuario(@RequestBody Usuario usuario) {
			return ResponseEntity.status(HttpStatus.OK) .body(repository.save (usuario));
	}
	@DeleteMapping("/{id}")
	public void deletarUsuario(@PathVariable long id) {
			repository.deleteById(id);
	}


}
