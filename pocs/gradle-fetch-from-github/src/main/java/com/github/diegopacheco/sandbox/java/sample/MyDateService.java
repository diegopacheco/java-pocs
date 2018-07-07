package com.github.diegopacheco.sandbox.java.sample;

import java.util.Date;

import com.github.diegopacheco.sandbox.java.arch.annotations.code.Refactoring;

public class MyDateService {

	@Refactoring(todo="This should not return void",
							 who_found="Diego Pacheco",when="07/07/2018",
							 why="Side effects are bad"
	)
	public void process() {
		System.out.println(new Date());
	}
	
}
