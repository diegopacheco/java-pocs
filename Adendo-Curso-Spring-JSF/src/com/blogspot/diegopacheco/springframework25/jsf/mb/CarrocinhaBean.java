package com.blogspot.diegopacheco.springframework25.jsf.mb;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.blogspot.diegopacheco.springframework25.jsf.pojo.Cachorro;
import com.blogspot.diegopacheco.springframework25.jsf.service.CarrocinhaService;

@Controller(value="carrocinhaBean")
public class CarrocinhaBean {
	
	private Integer id;
	private String nome;
	private String raca;
	private String resultado;
	
	@Resource
	private CarrocinhaService carrocinhaService;
	
	public CarrocinhaBean() {}

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
	
	public String getResultado() {
		return resultado;
	}
	public void setResultado(String resultado) {
		this.resultado = resultado;
	}

	public CarrocinhaService getCarrocinhaService() {
		return carrocinhaService;
	}
	public void setCarrocinhaService(CarrocinhaService carrocinhaService) {
		this.carrocinhaService = carrocinhaService;
	}

	
	public String catar(){
		Cachorro c = new Cachorro();
		c.setId(1);
		c.setNome(nome);
		c.setRaca(raca);
		
		Cachorro caoCatadado = (Cachorro)carrocinhaService.catar(c);
		resultado = "Cão: " + caoCatadado.getNome() + " - Catado! ";
		return "sucesso";
	}
		
}
