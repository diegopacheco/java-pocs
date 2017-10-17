package com.blogspot.diegopacheco.sandbox.github.java.akka.typed;

/**
 * 
 * People 
 *
 * @author pacheco
 * @version 1.0
 * @since 13/12/2010
 *
 */
public class People {
	
	private String name;

	public People() { }
	
	public People(String name) {
		super();
		this.name = name;
	}

	@Override
	public String toString() {
		return "People [name=" + name + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
