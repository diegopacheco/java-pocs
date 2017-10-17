package com.github.diegopacheco.sandbox.java.iffless.function2;

public class Pessoa {
	
	private String nome;
	private String telefone;
	private String twitter;
	private String email;
	private String fax;
	
	public Pessoa() {}

	public String getNome() {
		return get(nome);
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return get(telefone);
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getTwitter() {
		return get(twitter);
	}
	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}

	public String getEmail() {
		return get(email);
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getFax() {
		return get(fax);
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	
	private static String get(String str){
		return (str == null || "".equals(str)) ? "" : str;
	}
	
}
