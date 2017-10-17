package com.blogspot.diegopacheco.springframework25.jsf.service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.blogspot.diegopacheco.springframework25.jsf.dao.CarrocinhaDao;
import com.blogspot.diegopacheco.springframework25.jsf.pojo.Cachorro;

@Service(value="caveiraoService")
public class CaveiraoCarrocinhaServiceImpl implements CarrocinhaService {
	
	@Autowired
	private CarrocinhaDao dao;
	
	public Serializable catar(Cachorro c) {
		Serializable ser = dao.capturar(c);
		System.out.println("Cão: "+ ser + " não tem vez!");
		return ser;
	}

	public void setDao(CarrocinhaDao dao) {
		this.dao = dao;
	}	
}
