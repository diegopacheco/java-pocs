package com.blogspot.diegopacheco.cglib.playground.command.ws;

public class WebServiceCommandImpl implements WebServiceCommand{
	@Override
	public Object execute(Object execute) {
		System.out.println("Executing with: " + execute);
		return "hello :D";
	}
}
