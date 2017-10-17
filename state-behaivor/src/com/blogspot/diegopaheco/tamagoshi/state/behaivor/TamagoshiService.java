package com.blogspot.diegopaheco.tamagoshi.state.behaivor;

/**
 * 
 * @author Diego Pacheco
 *
 */
public class TamagoshiService {
	
	public void modificarAcao(String acao,Tamagoshi tama){
		
		Acao novaAcao = null;
		
		if ("Comendo".equals(acao)){
			novaAcao = new Comendo();
		}else if ("Brincando".equals(acao)){
			novaAcao = new Brincando();
		} else {
			novaAcao = new Morrendo();
		}
		
		tama.setAcaoCorrente(novaAcao);		
		novaAcao.fazerAlgo(tama);		
		
	}
	
	public String getOqueEstaAcontencendo(Tamagoshi tama){
		return  tama.getAcaoCorrente().getDescricao();
	}
	
}
