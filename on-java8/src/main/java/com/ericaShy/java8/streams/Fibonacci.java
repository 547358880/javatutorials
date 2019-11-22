package com.ericaShy.java8.streams;

import java.util.stream.Stream;

public class Fibonacci {

    int x = 1;

    Stream<Integer> numbers() {
        return Stream.iterate(0, i -> {
            int result = x + i;
            x = i;
            return result;
        });
    }
}
