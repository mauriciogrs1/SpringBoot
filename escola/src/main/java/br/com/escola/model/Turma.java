package br.com.escola.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table (name = "tb_turma")
public class Turma {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "id_turma")
	private long id;
	
	@NotNull
	@Column (name = "nome_turma")
	private String turma;
	
	@Column (name = "ativo_turma")
	private boolean ativo;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTurma() {
		return turma;
	}
	public void setTurma(String turma) {
		this.turma = turma;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
	
	
}
