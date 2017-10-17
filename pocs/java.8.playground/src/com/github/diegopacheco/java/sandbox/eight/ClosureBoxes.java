package com.github.diegopacheco.java.sandbox.eight;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Person {

	private String name;

	public Person() {
	}

	public Person(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void printName() {
		System.out.println(name);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + getOuterType().hashCode();
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (!getOuterType().equals(other.getOuterType()))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return name;
	}

	private Person getOuterType() {
		return this;
	}

}

public class ClosureBoxes {

	public static void main(String[] args) {

		Person pe1 = new Person("Diego");
		Person pe2 = new Person("Dessa");

		List<Person> ps = new ArrayList<Person>();
		ps.add(pe1);
		ps.add(pe2);

		System.out.println("Sorted ASC");
		Collections.sort(ps,
				(Person p1, Person p2) -> p1.getName().compareTo(p2.getName())
		);

		for (Person p : ps) {
			p.printName();
		}

	}

}
