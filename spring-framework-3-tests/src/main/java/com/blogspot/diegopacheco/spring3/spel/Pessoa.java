package com.blogspot.diegopacheco.spring3.spel;

public class Pessoa {
	
	private String nome;
	
	
	public Pessoa() {}
	
	public Pessoa(String nome) {
		super();
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Override
	public String toString() {
		return "Pessoa: " + getNome();
	}
	
}
