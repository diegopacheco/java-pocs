package com.blogspot.diegopaheco.domain.main;

import com.blogspot.diegopaheco.domain.Cor;
import com.blogspot.diegopaheco.domain.Tamagoshi;

/**
 * 
 * @author Diego Pacheco
 *
 */
public class TamagoshiDoThadeu {
	
	public static void main(String[] args) {
		
		Tamagoshi tama = new Tamagoshi();
		tama.setCor(Cor.AZUL);
		tama.setNome("Joãozinho");
		
		tama.modificarAcao("Brincando");
		tama.modificarAcao("Brincando");
		tama.modificarAcao("Brincando");
		
		tama.modificarAcao("Comendo");
		
		tama.modificarAcao("SeFerrou");
		tama.modificarAcao("SeFerrou");
		tama.modificarAcao("SeFerrou");
		tama.modificarAcao("SeFerrou");
		
		System.out.println( "O que Esta acontecendo: " + tama.getOqueEstaAcontencendo()  );
		System.out.println(" Status - Peso: " + tama.getPeso()  );
		System.out.println(" Status - Felicidade : " + tama.getFelicidade());
		
		
		Tamagoshi tama2 = new Tamagoshi();
		tama2.setCor(Cor.AZUL);
		tama2.setNome("Mariazinha");
		
		tama2.modificarAcao("Brincando");
		tama2.modificarAcao("Brincando");
		tama2.modificarAcao("Brincando");
		
		tama2.modificarAcao("Comendo");
		
		tama2.modificarAcao("Comendo");
		tama2.modificarAcao("Comendo");
		tama2.modificarAcao("Comendo");
		tama2.modificarAcao("Comendo");
		
		System.out.println( "O que Esta acontecendo: " + tama2.getOqueEstaAcontencendo()  );
		System.out.println(" Status - Peso: " + tama2.getPeso()  );
		System.out.println(" Status - Felicidade : " + tama2.getFelicidade());
		
	}
	
}
