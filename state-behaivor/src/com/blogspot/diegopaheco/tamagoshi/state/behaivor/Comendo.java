package com.blogspot.diegopaheco.tamagoshi.state.behaivor;


/**
 * 
 * @author Diego Pacheco
 *
 */
public class Comendo implements Acao {

	@Override
	public void fazerAlgo(Tamagoshi tama) {
		tama.setPeso( tama.getPeso() + 0.87  );				
	}

	@Override
	public String getDescricao() {
		return "Comendo";
	}

}
