package com.github.diegopacheco.spring.boot.x.microservice.simplesandbox;

public class GithubRepo {
	
	public String full_name;

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}
	
	@Override
	public String toString() {
		return full_name;
	}
	
}
