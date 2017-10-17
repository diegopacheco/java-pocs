package com.blogspot.diegopacheco.fluent.interfacejava.domain;

public class Venda {
	
	private Vendedor vendedor;
	private Cliente cliente;
	private Desconto desconto;
	private Produtos produtos;
	
	public Venda(Vendedor vendedor) {
		super();
		this.vendedor = vendedor;
		this.produtos = new Produtos();
	}
	
	public Venda paraCliente(String cliente){
		this.cliente = new Cliente(cliente);
		return this;
	}
	
	public Venda comDescontoDe(Integer percentagem){
		this.desconto = new Desconto(percentagem);
		return this;
	}
	
	public Venda oProduto(String nome){
		Produto p = new Produto(nome,10D);
		this.produtos.getProdutos().add(p);
		return this;
	}

	public void mostrandoDetalhes(){
		System.out.println(this.toString());
	}
	
	
	// getters 
	
	public Vendedor getVendedor() {
		return vendedor;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public Desconto getDesconto() {
		return desconto;
	}
		
	@Override
	public String toString() {
		
		String result = "";
		
		result = "Vendedor: " + vendedor.getNome() + "\n" +
		"Cliente: " + cliente.getNome() +  "\n" +
		"ComDescontoDe: " + desconto.getPorcetagem() + "%" +  "\n" +
		"OsProdutos: \n";
		
		for(Produto p: produtos.getProdutos()){
			result += "--> " + p.getNome() + " \n";
		}
		return result;		
	}
	
}
