package com.ericaShy.java8.streams;

import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

interface Matcher extends BiPredicate<Stream<Integer>, Predicate<Integer>> {}

/**
 * ?
 */
// stream.allMatch

public class Matching {

    // match(Stream, Predicate)
    static void show(Matcher match, int val) {
        System.out.println(
                match.test(IntStream.rangeClosed(1, 9)
                            .boxed()
                            .peek(n -> System.out.format("%d ", n)),
                        n -> n < val));
    }

    public static void main(String[] args) {
        System.out.println("start");

        /**
         * 输出:
         * 1 2 3 4 5 6 7 8 9 true
         * 1 2 3 4 false
         * 1 true
         * 1 2 3 4 5 6 7 8 9 false
         * 1 false
         * 1 2 3 4 5 6 7 8 9 true
         */
        show(Stream::allMatch, 10);
        show(Stream::allMatch, 4);
        show(Stream::anyMatch, 2);
        show(Stream::anyMatch, 0);
        show(Stream::noneMatch, 5);
        show(Stream::noneMatch, 0);
    }
}
