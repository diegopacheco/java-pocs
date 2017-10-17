package com.polimorfismo;

public class Pilot implements Caneta {
	
	@Override
	public void escreve() {
		System.out.println("escreve pilot");
	}
	
	// overload
	public void escreve(Integer cor) {
		System.out.println("escreve pilot" + cor);
	}

}
