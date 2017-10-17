package com.blogspot.diegopaheco.domain.stateless;

/**
 * 
 * @author Diego Pacheco
 *
 */
public class TabuadaService {
	
	
	public void calcularTaduadaDo(Integer numero){
		
		System.out.println("Calculando tabuada do: " + numero);
		
		for(int i = 1; i<=10; i++){
			System.out.println(numero + " x " + i + " = " + (numero * i)  );
		}
		
	}
	
}

