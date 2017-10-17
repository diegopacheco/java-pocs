package com.github.diegopacheco.sandbox.java.rulebook.main;

import com.deliveredtechnologies.rulebook.FactMap;
import com.deliveredtechnologies.rulebook.NameValueReferableMap;
import com.deliveredtechnologies.rulebook.lang.RuleBookBuilder;
import com.deliveredtechnologies.rulebook.model.RuleBook;

public class SimpleMain {
	public static void main(String[] args) {
		
		RuleBook ruleBook = RuleBookBuilder.create()
			    .addRule(rule -> rule.withNoSpecifiedFactType()
			      .then(f -> System.out.print("Hello "))
			      .then(f -> System.out.println("World")))
			    .build();
		
		ruleBook.run(new FactMap());
		
		NameValueReferableMap factMap = new FactMap();
		factMap.setValue("hello", "Hello ");
		factMap.setValue("world", " World");
		ruleBook.run(factMap);
		
	}
}
