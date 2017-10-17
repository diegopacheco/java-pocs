package com.blogspot.diegopacheco.spring3.spel;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Configuration
@Component("configBean")
@ImportResource("classpath:spring3-spel-only-beans.xml")
public class PojoAnnotationsSpel {
		
	@Value("#{c.target}")
	private String target;
	
	@Value("#{c.source}")
	private String source;
	
	@Value("#{c.nome}")
	private String nome;

	@Override
	public String toString() {
		return "target: " + target + " source: " + source + 
			   " nome: " + nome;			   
	}
	
	@Bean(name="pessoa")
	@Scope("prototype")
    public Pessoa pessoa() {
        return new Pessoa("Diego Pacheco");
    }
	
}
