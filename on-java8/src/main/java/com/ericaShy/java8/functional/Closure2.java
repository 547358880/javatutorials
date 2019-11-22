package com.ericaShy.java8.functional;

import java.util.function.IntSupplier;

public class Closure2 {

    IntSupplier makeFunc(int x) {
        int i = 0;
        return () -> x + i;
    }
}
