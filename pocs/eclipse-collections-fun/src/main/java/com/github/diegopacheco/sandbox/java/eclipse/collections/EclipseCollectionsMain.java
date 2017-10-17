package com.github.diegopacheco.sandbox.java.eclipse.collections;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.impl.factory.Lists;

public class EclipseCollectionsMain {
	public static void main(String[] args) {
		
		Person person1 = new Person("Sally", "Smith");
		Person person2 = new Person("Ted", "Watson");
		Person person3 = new Person("Mary", "Williams");
		
		MutableList<Person> people = Lists.mutable.with(person1, person2, person3);
		MutableList<String> lastNames = people.collect(Person::getLastName);
		assert("Smith, Watson, Williams".equals(lastNames.makeString()));
		
		System.out.println(people);
		System.out.println(lastNames);
		
		ImmutableList<Person> people2 = Lists.immutable.with(person1, person2, person3);
		ImmutableList<String> lastNames2 = people2.collect(Person::getLastName);
		
		System.out.println(people2);
		System.out.println(lastNames2);
		
		Stream<String> lastNames3 = people.stream().map(Person::getLastName);
		System.out.println(lastNames3.collect(Collectors.joining(", ")));
	}
}
