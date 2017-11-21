package com.github.diegopacheco.sandbox.java.consistent.hash;

public class SimpleHashFunction implements HashFunction {

	@Override
	public Integer hash(Object key) {
		Integer hash = key.toString().hashCode();
		for (int i = 0; i < key.toString().length(); i++) {
		    hash = hash*31 + key.toString().charAt(i);
		}
		if (hash<0)
			return hash * -1;
		else
			return hash;
	}

}
