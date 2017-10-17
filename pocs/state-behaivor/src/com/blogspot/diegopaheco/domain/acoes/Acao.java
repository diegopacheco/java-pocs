package com.blogspot.diegopaheco.domain.acoes;

import com.blogspot.diegopaheco.domain.Tamagoshi;

/**
 * 
 * @author Diego Pacheco
 *
 */
public interface Acao {
	
	public String getDescricao();
	public void fazerAlgo(Tamagoshi tama);
	
}