package com.sicredi.avaliacao.models;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Pauta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	private String descricao;
	@ManyToMany
	private List<Sessao> sessoes = new ArrayList<>();

	public Pauta(){
		super();
	}
	public Pauta(String titulo, String descricao) {
		super();
		this.titulo = titulo;
		this.descricao = descricao;
	}

	public List<Sessao> getSessoes() {
		return sessoes;
	}
	public void setSessoes(List<Sessao> sessoes) {
		this.sessoes = sessoes;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
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
	public String toString(){return this.id + "\t" + this.titulo + "\t\t" + this.descricao;}
}
