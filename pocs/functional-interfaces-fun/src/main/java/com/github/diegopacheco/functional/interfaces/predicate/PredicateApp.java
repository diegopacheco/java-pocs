package com.github.diegopacheco.functional.interfaces.predicate;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateApp {
    public static void main(String[] args) {
        List<String> languages = Arrays.asList(
                "Portuguese", "Spanish", "English", "Greek", "Italian");

        Predicate<String> goodLang = (s) -> s.startsWith("P");

        for (String language : languages) {
            if (goodLang.test(language))
                System.out.println(language);
        }
    }
}
