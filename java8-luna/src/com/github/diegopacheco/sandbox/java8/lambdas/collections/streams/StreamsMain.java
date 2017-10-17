package com.github.diegopacheco.sandbox.java8.lambdas.collections.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;

public class StreamsMain {
	
	public static void main(String[] args) {
		
		 List<Person> pessoas = new ArrayList<Person>();
		 
		 pessoas.add(new Person("Diego Pacheco", 30));
		 pessoas.add(new Person("Martin", 40));
		 pessoas.add(new Person("Neymar Jr", 22));
		 pessoas.add(new Person("Gandalfi", 1));
		 
		 Predicate<Person> menoresDeIdade = p -> p.getAge() >= 18;
		 Predicate<Person> maioresDeIdade = p -> p.getAge() <= 18;
		 
		 ToIntFunction<Person> getAge = p -> p.getAge();
		 
		 int sumOfAges = pessoas.stream()
				 		 .filter( maioresDeIdade )
				 		 .mapToInt( getAge )
				 		 .sequential()
				 		 .sum();
		 
		 int sumOfAgesMinor = 
				  pessoas.stream()
		 		 .filter( menoresDeIdade )
		 		 .mapToInt( getAge )
		 		 .parallel()
		 		 .sum();
		 
		 System.out.println("Sum of all people more than 18: " + sumOfAges);
		 System.out.println("Sum of all people less than 18: " + sumOfAgesMinor);
		 
	}
	
}
