package com.farmacia.seguranca;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.farmacia.model.UsuarioModel;

public class UserDetailsImpl implements UserDetails {

	private static final long serialVersionUID = 1L; //Apenas para controle interno
	
	private String userName;
	private String password;
	private List<GrantedAuthority> authorities;
	
	
	public UserDetailsImpl (UsuarioModel user) {
		
		this.userName = user.getUsuario();
		this.password = user.getSenha();
	}
		
	public UserDetailsImpl () {
		
	}
		
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}
	
								//IMPLENTANDO METODOS

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password; 
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return userName;
	}
	
						// ACRESCENTAR "TRUE" EM TODOS OS METODOS 

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
