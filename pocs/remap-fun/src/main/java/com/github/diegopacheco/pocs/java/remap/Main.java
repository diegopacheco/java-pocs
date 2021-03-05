package com.github.diegopacheco.pocs.java.remap;

import com.remondis.remap.Mapper;
import com.remondis.remap.Mapping;

import java.util.UUID;

public class Main{
  public static void main(String args[]){
    Mapper<Customer,Person> mapping = Mapping.from(Customer.class)
            .to(Person.class)
            .omitInSource(Customer::getAddress)
            .omitInDestination(Person::getAddress)
            .reassign(Customer::getName)
            .to(Person::getName)
            .replace(Customer::getGender, Person::getGender)
            .withSkipWhenNull(Boolean::booleanValue)
            .mapper();
    System.out.println(mapping);

    Customer c = new Customer();
    c.setAddress("rua xyt 200");
    c.setGender(true);
    c.setName("personX");
    c.setMail("x@x.com.x");
    c.setId(UUID.randomUUID());

    Person p = mapping.map(c);
    System.out.println(c);
    System.out.println(p);
  }
}
