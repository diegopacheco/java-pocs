package com.blogspot.diegopacheco.springframework25.testng;

import org.springframework.stereotype.Service;

@Service
public class CalculadoraAsync implements Calculadora {
	
	@Override
	public void dividir(final Double va, final Double vb, 
									     final ResultadoCallback callback) {
		new Runnable(){
			public void run() {
				callback.processar(va/vb);
			}
		}.run();
	}	
}
