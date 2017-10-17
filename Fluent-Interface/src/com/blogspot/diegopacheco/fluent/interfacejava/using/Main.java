package com.blogspot.diegopacheco.fluent.interfacejava.using;

import com.blogspot.diegopacheco.fluent.interfacejava.domain.Vendedor;

public class Main {
	public static void main(String[] args) {

		Vendedor.deNome("Abreu").
		  	     vende().
				 paraCliente("Rafael").
				 oProduto("Mouse Verde").
				 oProduto("Teclado de Pano").
				 comDescontoDe(20).
				 mostrandoDetalhes();

		
	}
}