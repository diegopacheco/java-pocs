package com.blogspot.diegopacheco.springframework25.jsf.pojo;

import java.io.Serializable;

public class Cachorro implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nome;
	private String raca;
	
	public Cachorro() { }

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

	public String getRaca() {
		return raca;
	}
	public void setRaca(String raca) {
		this.raca = raca;
	}
	
	@Override
	public String toString() {
		return "id: " + id + ",Nome: " + nome + ", Raça: " + raca;
	}
	
}