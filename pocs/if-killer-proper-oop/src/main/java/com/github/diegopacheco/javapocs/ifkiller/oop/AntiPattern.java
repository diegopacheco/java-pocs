package com.github.diegopacheco.javapocs.ifkiller.oop;

import java.util.Optional;

public class AntiPattern {

    enum Source{
        Brazil,
        Argentina,
        Guiana
    }

    enum Destination{
        Portuguese,
        Spanish,
        French
    }

    public Optional<String> getMapping(String source){
        if (source.equals(Source.Brazil.name())){
            return Optional.of(Destination.Portuguese.name());
        } else if (source.equals(Source.Argentina.name())){
            return Optional.of(Destination.Spanish.name());
        } else if (source.equals(Source.Guiana.name())){
            return Optional.of(Destination.French.name());
        }
        return Optional.empty();
    }

    public static void main(String[] args) {
        AntiPattern ap = new AntiPattern();
        System.out.println(ap.getMapping(Source.Brazil.name()));
        System.out.println(ap.getMapping(Source.Argentina.name()));
        System.out.println(ap.getMapping(Source.Guiana.name()));
    }

}
