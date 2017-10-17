package sem.polimorfismo;

import javax.swing.JOptionPane;

public class Main {
	public static void main(String[] args) {
		
		// 1. eu uso contratos diferentes
		CanetaBic a = new CanetaBic();
		PilotWbm7 b = new PilotWbm7();
		
		// 2 eu uso metodos diferentes
		// 3 eu nao consigo reusar o codigo
		a.escreveBic();
		b.escrevePilot();
		
		// 4. eu gero muito mais codigo, nao consigo ter transparencia
		Integer controle = new Integer(JOptionPane.showInputDialog("Digite 1 para bic, 2 para pilot, 3 as duas").toString());
		if (controle == 1){
			a.escreveBic();
		}else if (controle == 2){
			b.escrevePilot();
		} else{
			a.escreveBic();
			b.escrevePilot();
		}
		
	}
}
