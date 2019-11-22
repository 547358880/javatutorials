package com.ericaShy.java8.streams;

import static com.ericaShy.java8.onjava.Repeat.*;

public class Looping {

    static void hi() {
        System.out.println("Hi!");
    }

    public static void main(String[] args) {
        repeat(3, () -> System.out.println("Looping!"));
        repeat(2, Looping::hi);
    }
}
