package br.com.escola.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

@Entity
@Table (name = "tb_turma") //Criando tabeça SQL
public class Turma {
	
	//Atributos
	
	@Id //Chave primária da tabela
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "id_turma") //NOME DO ATRIBUTO NA TABELA(Em java é uma coisa na tabela é outra)
	private long id;
	
	@NotNull
	@Column (name = "nome_turma")
	private String turma;
	
	@Column (name = "ativo_turma")
	private boolean ativo;
	
	@OneToMany(mappedBy = "turma", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("turma")
    private List<Aluno> aluno;

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

	public List<Aluno> getAluno() {
		return aluno;
	}

	public void setAluno(List<Aluno> aluno) {
		this.aluno = aluno;
	}
	
		
	
	
	
	
}
