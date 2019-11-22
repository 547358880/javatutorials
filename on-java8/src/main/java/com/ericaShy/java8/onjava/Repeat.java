package com.ericaShy.java8.onjava;

import static java.util.stream.IntStream.*;

public class Repeat {

    public static void repeat(int n, Runnable action) {
        range(0, n).forEach(i -> action.run());
    }
}
