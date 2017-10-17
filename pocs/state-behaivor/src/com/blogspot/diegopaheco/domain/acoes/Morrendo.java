package com.blogspot.diegopaheco.domain.acoes;

import com.blogspot.diegopaheco.domain.Tamagoshi;

/**
 * 
 * @author Diego Pacheco
 *
 */
public class Morrendo implements Acao {

	@Override
	public void fazerAlgo(Tamagoshi tama) {
		
		tama.setFelicidade( 0 );
		tama.setPeso( tama.getPeso() - (tama.getPeso() / 2) );
		
	}

	@Override
	public String getDescricao() {
		return "Morrendo";
	}

}
