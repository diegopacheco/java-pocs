package com.blogspot.diegopaheco.tamagoshi.state.behaivor;

/**
 * 
 * @author Diego Pacheco
 *
 */
public class Tamagoshi {
	
	// Variaveis de instancia/classe
	
	private String nome;
	private Double peso = 10d;
	private Integer felicidade = 50;
	
	private Acao acaoCorrente;	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Double getPeso() {
		return peso;
	}
	public void setPeso(Double peso) {
		this.peso = peso;
	}
	
	public Integer getFelicidade() {
		return felicidade;
	}
	public void setFelicidade(Integer felicidade) {
		this.felicidade = felicidade;
	}

	public Acao getAcaoCorrente() {
		return acaoCorrente;
	}
	public void setAcaoCorrente(Acao acaoCorrente) {
		this.acaoCorrente = acaoCorrente;
	}
	
}
