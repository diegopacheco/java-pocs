package com.blogspot.diegopaheco.domain;

import com.blogspot.diegopaheco.domain.acoes.Acao;
import com.blogspot.diegopaheco.domain.acoes.Brincando;
import com.blogspot.diegopaheco.domain.acoes.Comendo;
import com.blogspot.diegopaheco.domain.acoes.Morrendo;



/**
 * 
 * @author Diego Pacheco
 *
 */
public class Tamagoshi {
	
	// Variaveis de instancia/classe
	
	private String nome;
	private Cor cor;
	private Double peso = 10d;
	private Integer felicidade = 50;
	
	private Acao acaoCorrente;	
	
	public void modificarAcao(String acao){
		
		Acao novaAcao = null;
		
		if ("Comendo".equals(acao)){
			novaAcao = new Comendo();
		}else if ("Brincando".equals(acao)){
			novaAcao = new Brincando();
		} else {
			novaAcao = new Morrendo();
		}
		
		acaoCorrente = novaAcao;
		
		acaoCorrente.fazerAlgo(this);		
	}
	
	public String getOqueEstaAcontencendo(){
		return acaoCorrente.getDescricao();
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Cor getCor() {
		return cor;
	}
	public void setCor(Cor cor) {
		this.cor = cor;
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

	
}
