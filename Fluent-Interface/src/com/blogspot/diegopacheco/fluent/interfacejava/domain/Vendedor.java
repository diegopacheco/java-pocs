package com.blogspot.diegopacheco.fluent.interfacejava.domain;

public class Vendedor {
	
	private String nome;
	
	private Vendedor(String nome) {
		this.nome = nome;
	}
	
	public static Vendedor deNome(String nome){
		Vendedor v = new Vendedor(nome);
		return v;		
	}
	
	public Venda vende(){
		return new Venda(this);
	}
	
	public String getNome() {
		return nome;
	}	
}
