package com.blogspot.diegopacheco.springframework25.annotations.java;

import java.lang.reflect.Field;

public class TestaAnotacaoMain {

	public static void main(String[] args) {

		Pessoa p = new Pessoa();
		p.setNome("Diego Pacheco");
				
		try{
			validate(p);
			System.out.println("Objeto válido!");
		}catch(Exception e){
			System.out.println("Objeto inválido!");
			e.printStackTrace();
		}		
		
	}

	@SuppressWarnings("unchecked")
	public static void validate(Pessoa p)  throws Exception {
		Class<Pessoa> clazz = (Class<Pessoa>) p.getClass();
		Field[] fields = clazz.getDeclaredFields();
		for (Field field : fields) {
			if (field.isAnnotationPresent(CampoObrigatorio.class)) {
				field.setAccessible(true);
				if (field.get(p) == null){
					throw new RuntimeException("O campo obrigatório não foi informado. Objeto inválido! ");
				}
					
			}
		}
	}
	
}
