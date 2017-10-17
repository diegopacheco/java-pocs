package com.blogspot.diegopacheco.terracota.pojo;

public class Pessoa {
	
	private String nome;
	private String email;
	
	public Pessoa() {}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "nome: " + nome + ", email: " + email;
	}
}
