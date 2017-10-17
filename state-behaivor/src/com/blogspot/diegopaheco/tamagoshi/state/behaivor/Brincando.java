package com.blogspot.diegopaheco.tamagoshi.state.behaivor;


/**
 * 
 * @author Diego Pacheco
 *
 */
public class Brincando implements Acao{
	
	@Override
	public void fazerAlgo(Tamagoshi tama) {
		tama.setFelicidade( tama.getFelicidade() + 2 );
	}
	
	@Override
	public String getDescricao() {
		return "Brincando";
	}
}
