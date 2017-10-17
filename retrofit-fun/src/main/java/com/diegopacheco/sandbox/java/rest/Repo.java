package com.diegopacheco.sandbox.java.rest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Repo {
	
	private String id;
	private String name;
	private String full_name;
	
	public Repo() {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFull_name() {
		return full_name;
	}
	public void setFull_name(String name) {
		this.full_name = name;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
	}

	@Override
	public String toString() {
		return "Repo [id=" + id + ", name=" + name + ", full_name=" + full_name + "]";
	}
	
}
