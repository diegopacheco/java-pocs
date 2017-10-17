package com.polimorfismo;

import java.util.Arrays;
import java.util.List;


public class Main {
	public static void main(String[] args) {
		
		// 1. vantagem: tem o mesmo contrato, usa-se as mesmas abstracoes
		Caneta a = new Bic();
		Caneta b = new Pilot();
		
		Caneta c = a;
		
		List<Caneta> canetas = Arrays.asList(a,b);
		
		// 2. eu uso o mesmo metodo
		// 3. eu posso reusar o codigo
		//a.escreve();
		//b.escreve();

// Versao 1		
//		Integer controle = new Integer(JOptionPane.showInputDialog("Digite 1 para bic, 2 para pilot, 3 as duas").toString());
//		if (controle == 1){
//			c = a;
//		}else if (controle == 2){
//			c = b;
//		} else{
//			for( Caneta x : canetas ){
//				x.escreve();
//			}
//		}
//		c.escreve();
// melhor que faz em java
		
	}
}
