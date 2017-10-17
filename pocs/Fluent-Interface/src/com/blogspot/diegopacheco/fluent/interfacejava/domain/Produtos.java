package com.blogspot.diegopacheco.fluent.interfacejava.domain;

import java.util.ArrayList;
import java.util.List;

public class Produtos {
	
	private List<Produto> produtos;
	
	public Produtos() {
		produtos = new ArrayList<Produto>();
	}

	public List<Produto> getProdutos() {
		return produtos;
	}
	
}
