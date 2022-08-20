import reactor.core.publisher.Flux;

import java.util.Arrays;
import java.util.List;

public class Main {

    private static List<String> words = Arrays.asList("I",
            "have",
            "99",
            "Problems",
            "and",
            "Java",
            "Aint",
            "one");

    public static void main(String args[]) {
        Flux.
            fromIterable(words).
            map( word -> word.toUpperCase()).
            filter( word -> word.length()>=2 ).
            subscribe(System.out::println);
    }
}
