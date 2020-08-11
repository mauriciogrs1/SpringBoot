package com.farmacia.seguranca;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.farmacia.model.UsuarioModel;
import com.farmacia.repository.UsuarioRepository;

@Service  // Quando a Classe trata-se de um serviço
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired // INJETANDO UserRepository
	private UsuarioRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException  {
		Optional <UsuarioModel> user = userRepository.findByUsuario(userName); // O que vai entrar dentro do Objeto
		user.orElseThrow(()  -> new UsernameNotFoundException(userName + " not found.")); // Caso tenha um erro ele passará essa menssagem de erro
		
		return user.map(UserDetailsImpl::new).get(); 
	}

}
