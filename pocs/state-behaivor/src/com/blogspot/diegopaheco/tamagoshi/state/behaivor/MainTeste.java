package com.blogspot.diegopaheco.tamagoshi.state.behaivor;

/**
 * 
 * @author Diego Pacheco
 *
 */
public class MainTeste {
	public static void main(String[] args) {
		
		Tamagoshi tama = new Tamagoshi();
		tama.setNome("Zeze");
		
		TamagoshiService ts = new TamagoshiService();
		ts.modificarAcao("Comendo", tama);
		ts.modificarAcao("Comendo", tama);
		ts.modificarAcao("Comendo", tama);
		ts.modificarAcao("Comendo", tama);
		
		System.out.println( ts.getOqueEstaAcontencendo(tama)  );
		System.out.println(" Status - Peso: " + tama.getPeso()  );
		System.out.println(" Status - Felicidade : " + tama.getFelicidade());
		
	}
}
