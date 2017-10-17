package com.blogspot.diegopacheco.springframework25.annotations.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component()
public class Autor {
	
	private Integer id;
	private String nome;
	
	@Autowired
	private Livro livro;
	
	public Autor() {
		id=0;
		nome="Sem nome";
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public Livro getLivro() {
		return livro;
	}
	public void setLivro(Livro livro) {
		this.livro = livro;
	}	
	
	@Override
	public String toString() {
		return "id: " + id + ",Nome: " + nome + ", Livro: " + livro;
	}
	
}
