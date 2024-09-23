package com.github.diegopacheco.java23.features.JEP_473;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Gatherer;
import java.util.stream.Stream;

/**
 * JEP 473: Stream Gatherers (Second Preview)
 * https://openjdk.org/jeps/473
 *
 */
public class FeatureJEP473 {

    record WindowFixed<TR>(int windowSize)
            implements Gatherer<TR, ArrayList<TR>, List<TR>>
    {

        public WindowFixed {
            // Validate input
            if (windowSize < 1)
                throw new IllegalArgumentException("window size must be positive");
        }

        @Override
        public Supplier<ArrayList<TR>> initializer() {
            // Create an ArrayList to hold the current open window
            return () -> new ArrayList<>(windowSize);
        }

        @Override
        public Integrator<ArrayList<TR>, TR, List<TR>> integrator() {
            // The integrator is invoked for each element consumed
            return Gatherer.Integrator.ofGreedy((window, element, downstream) -> {

                // Add the element to the current open window
                window.add(element);

                // Until we reach our desired window size,
                // return true to signal that more elements are desired
                if (window.size() < windowSize)
                    return true;

                // When the window is full, close it by creating a copy
                var result = new ArrayList<TR>(window);

                // Clear the window so the next can be started
                window.clear();

                // Send the closed window downstream
                return downstream.push(result);

            });
        }

        // The combiner is omitted since this operation is intrinsically sequential,
        // and thus cannot be parallelized

        @Override
        public BiConsumer<ArrayList<TR>, Downstream<? super List<TR>>> finisher() {
            // The finisher runs when there are no more elements to pass from
            // the upstream
            return (window, downstream) -> {
                // If the downstream still accepts more elements and the current
                // open window is non-empty, then send a copy of it downstream
                if(!downstream.isRejecting() && !window.isEmpty()) {
                    downstream.push(new ArrayList<TR>(window));
                    window.clear();
                }
            };
        }
    }

    public static void main(String[] args) {
        long numberOfWords =
                Stream.of("the", "", "fox", "jumps", "over", "the", "", "dog")
                        .filter(Predicate.not(String::isEmpty))
                        .collect(Collectors.counting());
        System.out.println(numberOfWords);

        Stream.of(1,2,3,4,5,6,7,8,9).gather(new WindowFixed(3)).toList().forEach(System.out::println);

    }
}
