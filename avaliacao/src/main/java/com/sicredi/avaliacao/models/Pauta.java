package com.sicredi.avaliacao.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Pauta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String descricao;
	@ManyToMany
	private List<Sessao> sessoes = new ArrayList<>();


//Construtor


	public Pauta(){
		super();
	}

	public Pauta(String nome, String descricao) {
		super();
		this.nome = nome;
		this.descricao = descricao;
	}
	
	//Getters e Setters
	public List<Sessao> getSessoes() {
		return sessoes;
	}

	public void setSessoes(List<Sessao> sessoes) {
		this.sessoes = sessoes;
	}
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString(){return this.id + "\t" + this.nome + "\t\t" + this.descricao;}
}
