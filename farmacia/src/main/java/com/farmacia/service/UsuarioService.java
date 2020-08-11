package com.farmacia.service;

import java.nio.charset.Charset;
import java.util.Optional;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.farmacia.model.UserLogin;
import com.farmacia.model.UsuarioModel;
import com.farmacia.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
					// REGRA PARA CADASTRAR USUARIO
	
	@Autowired
	private UsuarioRepository repository;
	public UsuarioModel CadastrarUsuario ( UsuarioModel usuario) { // Metodo Cadastrar
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		String senhaEncoder = encoder.encode(usuario.getSenha());
		usuario.setSenha(senhaEncoder);
		
		return repository.save(usuario);
	}
				// REGRA PARA TUDO QUE SE REFERE A LOGAR
	
	public Optional<UserLogin> Logar (Optional<UserLogin> user){ //Metodo Logar
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		Optional<UsuarioModel> usuario = repository.findByUsuario(user.get().getUsuario()); // pesquisa de usuario
		
		if (usuario.isPresent()) { // compara a senha do objeto "usuario" com a senha que o cliente digitou
			if(encoder.matches(user.get().getSenha(), usuario.get().getSenha())) { //Meteodo de comparar as senhas
				
				String auth =  user.get().getUsuario() + ":" + user.get().getSenha();
				byte [] encondedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
				String authHeader = "Basic " + new String(encondedAuth);
				
				user.get().setToken(authHeader);
				user.get().setNome(usuario.get().getNome());
				
				return user;
				
			}
		}
	
		return null;
	
	}
	
	

}
