package com.blogspot.diegopacheco.fluent.interfacejava.domain;

public class Produto {
	
	private String nome;
	private Double valor;
	
	public Produto(String nome, Double valor) {
		super();
		this.nome = nome;
		this.valor = valor;
	}
	
	public String getNome() {
		return nome;
	}

	public Double getValor() {
		return valor;
	}	
}
