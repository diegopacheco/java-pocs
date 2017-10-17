package com.blogspot.diegopacheco.terracota.pojo;

import java.util.HashMap;
import java.util.Map;

public class Alunos {

	private Map<String, Pessoa> pessoas;

	public Alunos() {
		pessoas = new HashMap<String, Pessoa>();
	}

	public void adicionarAlunos(Pessoa aluno) {
		synchronized (pessoas) {
			pessoas.put(aluno.getEmail(), aluno);
		}
	}

	public Pessoa obterAluno(String email) {
		Pessoa p = null;
		synchronized (pessoas) {
			p = pessoas.get(email);
		}
		if (p != null)
			return p;
		else
			return new Pessoa();
	}
	
	
}
