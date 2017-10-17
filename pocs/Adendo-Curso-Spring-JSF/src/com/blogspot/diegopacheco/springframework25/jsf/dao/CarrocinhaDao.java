package com.blogspot.diegopacheco.springframework25.jsf.dao;

import java.io.Serializable;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.blogspot.diegopacheco.springframework25.jsf.pojo.Cachorro;

@Repository(value="carrocinhaDao")
public class CarrocinhaDao {
	
	public Serializable capturar(Cachorro c){
		System.out.println("Cachorro: " + c + " persistido com sucesso ");
		return c;
	}
	
}
