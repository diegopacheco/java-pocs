package com.blogspot.diegopacheco.camel.cxf;

public class Person {
	
	private String firstName;
	private String lastName;
	private String city;
	
	public Person() {}	

	public Person(String firstName, String lastName, String city) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.city = city;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
	
	@Override
	public String toString() {
		return this.firstName + " - " + lastName + " - " + city;
	}
	
}
