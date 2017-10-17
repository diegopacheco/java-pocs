package com.blogspot.diegopaheco.domain.acoes;

import com.blogspot.diegopaheco.domain.Tamagoshi;

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
