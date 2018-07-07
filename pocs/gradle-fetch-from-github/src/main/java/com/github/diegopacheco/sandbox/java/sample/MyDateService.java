package com.github.diegopacheco.sandbox.java.sample;

import java.util.Date;

import com.github.diegopacheco.sandbox.java.arch.annotations.arch.Architecture;
import com.github.diegopacheco.sandbox.java.arch.annotations.arch.Bound;
import com.github.diegopacheco.sandbox.java.arch.annotations.arch.Profile;
import com.github.diegopacheco.sandbox.java.arch.annotations.arch.ServiceNature;
import com.github.diegopacheco.sandbox.java.arch.annotations.code.Refactoring;

@ServiceNature(
		bound=Bound.LATENCY,
		profile=Profile.FAST_PIPELINE,
		main_architecture=Architecture.REQUEST_DRIVEN
)
public class MyDateService {

	@Refactoring(todo="This should not return void",
							 who_found="Diego Pacheco",when="07/07/2018",
							 why="Side effects are bad"
	)
	public void process() {
		System.out.println(new Date());
	}
	
}
