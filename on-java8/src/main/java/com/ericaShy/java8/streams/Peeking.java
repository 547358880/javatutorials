package com.ericaShy.java8.streams;

public class Peeking {

    public static void main(String[] args) throws Exception {

        int i = 10;

        FileToWords.stream(Peeking.class.getClassLoader().getResource("Chess.dat").toURI())
                .skip(21)
                .limit(4)
                .map(w -> w + " ")
                .peek(System.out::print)
                .map(String::toUpperCase)
                .peek(System.out::print)
                .map(String::toLowerCase)
                .forEach(System.out::print);
    }

}
