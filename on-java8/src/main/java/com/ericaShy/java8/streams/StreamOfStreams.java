package com.ericaShy.java8.streams;

import java.util.stream.Stream;

/**
 * 对照FlatMap.java
 */
public class StreamOfStreams {

    public static void main(String[] args) {
        Stream.of(1, 2, 3)
                .map(i -> Stream.of("Gonzo", "Kermit", "Beaker"))
                .map(e -> e.getClass().getName())
                .forEach(System.out::println);
    }

}
