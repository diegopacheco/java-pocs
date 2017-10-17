package com.blogspot.diegopacheco.terracota.service;

import com.blogspot.diegopacheco.terracota.pojo.Alunos;
import com.blogspot.diegopacheco.terracota.pojo.Pessoa;

public class TurmaService {
	
	private Alunos alunos;
	
	public void adicionarDezMilAlunos(){				
		synchronized (alunos) {
			for(int i=0;i<=10000;i++){
				Pessoa p1 = new Pessoa();
				p1.setNome("Aluno" + i);
				p1.setEmail("aluno" + i + "@ilegra.com");
				alunos.adicionarAlunos(p1);
			}			
		}		
	}
	
	public void mostrarAlunoN1(){
		
		synchronized (alunos) {
			Pessoa p1 = alunos.obterAluno("aluno0@ilegra.com");
			System.out.println("aluno 1 = " + p1);
		}
		
	}

	public void setAlunos(Alunos alunos) {
		this.alunos = alunos;
	}
	
}
