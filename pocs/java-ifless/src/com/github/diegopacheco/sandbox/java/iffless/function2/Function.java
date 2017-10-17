package com.github.diegopacheco.sandbox.java.iffless.function2;

public class Function {
	public static void main(String[] args) {
		
		Pessoa p = new Pessoa();
		p.setEmail("pessoa@pessoa.com");
		p.setFax(null);
		p.setTwitter("");
		p.setNome("pessoa");
		
		//
		//  Print only the non-blank fileds, string != null, string != ""
		// 
		System.out.println( 
							  p.getNome()    + separator() + 
							  p.getEmail()   + separator() + 
							  p.getTwitter() + separator() + 
							  p.getFax()     + separator()
						  );		
	}	
	
	private static String separator(){
		return " - ";
	}
	
}
