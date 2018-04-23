package com.github.diegopacheco.sandbox.java.jackson;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;

public class SimplePojo {
	
	private static SimplePojo instance;
	
	private String name;
	private Integer age;
	
	private Map<String,String> family;
	
	private SimplePojo() {}
	
	@JsonCreator
	public static synchronized SimplePojo getInstance() {
		if(instance==null) {
			instance = new SimplePojo();
		}
		return instance;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Map<String, String> getFamily() {
		return family;
	}
	public void setFamily(Map<String, String> family) {
		this.family = family;
	}

	@Override
	public String toString() {
		return "SimplePojo [name=" + name + ", age=" + age + ", family=" + family + "]";
	}
	
}
