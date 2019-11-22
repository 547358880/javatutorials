package com.ericaShy.java8.streams;

import java.util.Optional;
import java.util.stream.Stream;

public class OptionalBasic {

    static void test(Optional<String> optString) {
        if (optString.isPresent()) {
            System.out.println(optString.get());
        } else {
            System.out.println("Nothing inside!");
        }
    }

    public static void main(String[] args) {
        test(Stream.of("Epithets").findFirst());
        test(Stream.<String>empty().findFirst());
    }

}
