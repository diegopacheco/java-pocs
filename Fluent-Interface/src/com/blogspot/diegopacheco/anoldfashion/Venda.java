package com.blogspot.diegopacheco.anoldfashion;

import java.util.List;

public class Venda {
	
	private Vendedor vendedor;
	private Cliente cliente;
	private Desconto desconto;
	private List<Produto> produtos;
	
	public Venda() {
		// TODO Auto-generated constructor stub
	}

	public Venda(Vendedor vendedor, Cliente cliente, Desconto desconto,
			List<Produto> produtos) {
		super();
		this.vendedor = vendedor;
		this.cliente = cliente;
		this.desconto = desconto;
		this.produtos = produtos;
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Desconto getDesconto() {
		return desconto;
	}

	public void setDesconto(Desconto desconto) {
		this.desconto = desconto;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	@Override
	public String toString() {
		
		String result = "";
		
		result = "Vendedor: " + vendedor.getNome() + "\n" +
		"Cliente: " + cliente.getNome() +  "\n" +
		"ComDescontoDe: " + desconto.getPorcetagem() + "%" +  "\n" +
		"OsProdutos: \n";
		
		for(Produto p: produtos){
			result += "--> " + p.getNome() + " \n";
		}
		return result;		
	}
	
}
