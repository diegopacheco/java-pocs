package com.github.diegopacheco.javapocs.ifkiller.oop;

import java.util.Optional;

/**
 * Here we are using proper OOP via Polymorphism to avoid the use of if/else.
 * Another way to see this is that we are in fact using the Strategy Pattern.
 * Here we are letting the compiler do the work for us, we are not using if/else.
 *
 * Recommend take a look here: https://github.com/diegopacheco/java-pocs/tree/master/pocs/if-alternatives-fun
 *
 * Could we savage the enums if we had another field language there, yes but enums still suck avoid them.
 */
public class PatternPolymorphism {

    interface Speaker{
        String toLanguage();
        Optional<String> toLanguageOptional();
    }

    class BrazilSpeaker implements Speaker{
        @Override
        public String toLanguage() {
            return "Portuguese";
        }
        @Override
        public Optional<String> toLanguageOptional() {
            return Optional.of(toLanguage());
        }
    }

    class ArgentinaSpeaker implements Speaker{
        @Override
        public String toLanguage() {
            return "Spanish";
        }
        @Override
        public Optional<String> toLanguageOptional() {
            return Optional.of(toLanguage());
        }
    }

    class GuianaSpeaker implements Speaker{
        @Override
        public String toLanguage() {
            return "French";
        }
        @Override
        public Optional<String> toLanguageOptional() {
            return Optional.of(toLanguage());
        }
    }

    Optional<String> getLanguage(Speaker speaker){
        return speaker.toLanguageOptional();
    }

    public static void main(String[] args) {
        PatternPolymorphism pp = new PatternPolymorphism();
        System.out.println(pp.getLanguage(pp.new BrazilSpeaker()));
        System.out.println(pp.getLanguage(pp.new ArgentinaSpeaker()));
        System.out.println(pp.getLanguage(pp.new GuianaSpeaker()));
    }

}
