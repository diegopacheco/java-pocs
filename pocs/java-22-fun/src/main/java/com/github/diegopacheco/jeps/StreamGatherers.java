package com.github.diegopacheco.jeps;

import java.util.stream.Stream;

public class StreamGatherers {

    record DistinctByLength(String str) {
        @Override public boolean equals(Object obj) {
            return obj instanceof DistinctByLength(String other)
                    && str.length() == other.length();
        }
        @Override public int hashCode() {
            return str == null ? 0 : Integer.hashCode(str.length());
        }
    }

    public static void run(){
        System.out.println("461: Stream Gatherers (Preview)");

        var result = Stream.of("foo", "bar", "baz", "quux")
                .map(DistinctByLength::new)
                .distinct()
                .map(DistinctByLength::str)
                .toList();
        System.out.println(result);
    }
}
