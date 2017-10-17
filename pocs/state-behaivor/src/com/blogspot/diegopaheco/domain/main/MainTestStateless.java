package com.blogspot.diegopaheco.domain.main;

import com.blogspot.diegopaheco.domain.stateless.TabuadaService;

/**
 * 
 * @author Diego Pacheco
 *
 */
public class MainTestStateless {
	public static void main(String[] args) {
		
		TabuadaService ts = new TabuadaService();
		ts.calcularTaduadaDo(2);
		
		//TabuadaService ts2 = new TabuadaService();
		ts.calcularTaduadaDo(3);
		
		//TabuadaService ts3 = new TabuadaService();
		ts.calcularTaduadaDo(5);
		
		System.out.println("Fim");
		
	}
}
