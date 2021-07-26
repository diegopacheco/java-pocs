package com.github.diegopacheco.design.patterns.structural.facde;

public class Main {
    public static void main(String[] args) {
        SecureFacade facade = new SecureFacade();
        SecurePerson person =  facade.encrypt("Diego","123456");
        System.out.println(person);
        System.out.println(facade.decrypt(person.getEncryptedName(),person.getPassword()));
    }
}
