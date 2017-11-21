package com.github.diegopacheco.sandbox.java.consistent.hash;

public class SimpleHashFunction implements HashFunction {

	@Override
	public Integer hash(Object key) {
		int hash = 7;
		for (int i = 0; i < key.toString().length(); i++) {
		    hash = hash*31 + key.toString().charAt(i);
		}
		return hash;
	}

}
