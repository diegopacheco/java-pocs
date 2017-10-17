package com.blogspot.diegopacheco.camel.pojo;

import java.io.Serializable;

public class Person implements Serializable{
	
	private static final long serialVersionUID = 1L;

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
		return "firstName: " + firstName + ",lastName: " + lastName + ",city: " + city;
	}
	
}
