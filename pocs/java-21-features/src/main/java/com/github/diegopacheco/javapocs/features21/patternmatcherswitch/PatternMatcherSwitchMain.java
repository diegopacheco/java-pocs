package com.github.diegopacheco.javapocs.features21.patternmatcherswitch;

public class PatternMatcherSwitchMain {

    static String formatterPatternSwitch(Object obj) {
        return switch (obj) {
            case Integer i -> String.format("int %d", i);
            case Long l    -> String.format("long %d", l);
            case Double d  -> String.format("double %f", d);
            case String s  -> String.format("String %s", s);
            default        -> obj.toString();
        };
    }

    static void nullCheck(String s) {
        switch (s) {
            case null         -> System.out.println("Oops is null");
            case "Foo", "Bar" -> System.out.println("Great");
            default           -> System.out.println("Ok is default");
        }
    }

    static void testStringNew(String response) {
        switch (response) {
            case null -> { }
            case String s
                    when s.equalsIgnoreCase("YES") -> {
                System.out.println("You got it - YES");
            }
            case String s
                    when s.equalsIgnoreCase("NO") -> {
                System.out.println("Shame - NO");
            }
            case String s -> {
                System.out.println("Sorry? " + s);
            }
        }
    }

    sealed interface CardClassification permits Suit, Tarot {}
    public enum Suit implements CardClassification { CLUBS, DIAMONDS, HEARTS, SPADES }
    final class Tarot implements CardClassification {}

    static void exhaustiveSwitchWithBetterEnumSupport(CardClassification c) {
        switch (c) {
            case Suit.CLUBS -> {
                System.out.println("It's clubs");
            }
            case Suit.DIAMONDS -> {
                System.out.println("It's diamonds");
            }
            case Suit.HEARTS -> {
                System.out.println("It's hearts");
            }
            case Suit.SPADES -> {
                System.out.println("It's spades");
            }
            case Tarot t -> {
                System.out.println("It's a tarot");
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(formatterPatternSwitch("ten"));
        System.out.println(formatterPatternSwitch(10));
        System.out.println(formatterPatternSwitch(10.0));

        nullCheck(null);
        nullCheck("Boo");

        testStringNew("YES");
        testStringNew("maybe");

        exhaustiveSwitchWithBetterEnumSupport(Suit.CLUBS);
    }
}
