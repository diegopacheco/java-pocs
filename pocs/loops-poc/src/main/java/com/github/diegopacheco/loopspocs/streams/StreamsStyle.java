package com.github.diegopacheco.loopspocs.streams;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamsStyle {
    public static void main(String[] args) {
        List<Integer> result =
        IntStream.range(0, 10)
                .boxed()
                .filter( n -> n % 2 ==0 )
                .collect(Collectors.toList());
        System.out.println(result);
    }
}
