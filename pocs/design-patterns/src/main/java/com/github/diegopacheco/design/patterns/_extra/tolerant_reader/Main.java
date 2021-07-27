package com.github.diegopacheco.design.patterns._extra.tolerant_reader;

import java.util.UUID;

public class Main {
    public static void main(String[] args) {
        PersonV1 personv1 = new PersonV1("John Doe","doe@johnm.com");
        PersonSerializer.writeV1(personv1,"/tmp/personv1.out");
        PersonV1 v12 = PersonSerializer.readV1("/tmp/personv1.out");
        System.out.println("Write V1 - Read V1 == " + v12);

        PersonV2 personv2 = new PersonV2("John Doe","doe@johnm.com","Male", UUID.randomUUID());
        PersonSerializer.writeV2(personv2,"/tmp/personv2.out");
        PersonV1 v22 = PersonSerializer.readV1("/tmp/personv2.out");
        System.out.println("Write V2 - Read V1 == " + v22);
    }
}
