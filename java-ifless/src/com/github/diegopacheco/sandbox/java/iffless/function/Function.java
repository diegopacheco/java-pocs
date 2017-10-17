package com.github.diegopacheco.sandbox.java.iffless.function;

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
							  get(p.getNome())    + " - " + 
							  get(p.getEmail())   + " - " + 
							  get(p.getTwitter()) + " - " + 
							  get(p.getFax())     + " - "
						  );
		
	}	
	
	private static String get(String str){
		return (str == null || "".equals(str)) ? "" : str;
	}
	
}
