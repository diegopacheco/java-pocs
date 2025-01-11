package com.github.diegopacheco.javapocs.ifkiller.oop;

import java.util.Optional;

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
