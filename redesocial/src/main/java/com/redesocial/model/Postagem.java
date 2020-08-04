package com.redesocial.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

@Entity
@Table (name = "tb_postagem")
public class Postagem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	private String descricaoPost;
	
	@NotNull
	private int gostei;
	
	@ManyToOne
    @JsonIgnoreProperties("postagem")
    private Tema tema;
	
	@ManyToOne
    @JsonIgnoreProperties("postagem")
    private Usuario usuario;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescricaoPost() {
		return descricaoPost;
	}

	public void setDescricaoPost(String descricaoPost) {
		this.descricaoPost = descricaoPost;
	}

	public int getGostei() {
		return gostei;
	}

	public void setGostei(int gostei) {
		this.gostei = gostei;
	}

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	
	
	

}
