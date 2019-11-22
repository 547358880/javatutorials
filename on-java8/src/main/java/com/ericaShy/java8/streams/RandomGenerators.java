package com.ericaShy.java8.streams;

import java.util.Random;
import java.util.stream.Stream;

/**
 * 随机数流
 */
public class RandomGenerators {

    public static <T> void show(Stream<T> stream) {
        stream
            .limit(4)
            .forEach(System.out::println);
        System.out.println("++++++++++++++++");
    }

    public static void main(String[] args) {
        Random rand = new Random(47);
        show(rand.ints().boxed());
    }
}
