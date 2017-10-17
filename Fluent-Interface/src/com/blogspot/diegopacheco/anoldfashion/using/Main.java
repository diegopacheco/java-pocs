package com.blogspot.diegopacheco.anoldfashion.using;

import java.util.ArrayList;
import java.util.List;

import com.blogspot.diegopacheco.anoldfashion.*;

public class Main {
	public static void main(String[] args) {
		
		Cliente cliente = new Cliente();
		cliente.setNome("Rafael");
		
		Vendedor vendedor = new Vendedor();
		vendedor.setNome("Abreu");
		
		List<Produto> produtos = new ArrayList<Produto>();
		
		Produto p1 = new Produto();
		p1.setNome("Mouse Verde");
		p1.setValor(10D);
		
		Produto p2 = new Produto();
		p2.setNome("Teclado de Pano");
		p2.setValor(10D);
		
		produtos.add(p1);
		produtos.add(p2);
		
		Desconto desconto = new Desconto();
		desconto.setPorcetagem(20);
		
		Venda venda = new Venda();
		venda.setCliente(cliente);
		venda.setVendedor(vendedor);
		venda.setDesconto(desconto);
		venda.setProdutos(produtos);
		
		VendaService vendaService = new VendaService();
		Venda vendaSalva = vendaService.salvar(venda);
		
		System.out.println(vendaSalva);
		
	}
}