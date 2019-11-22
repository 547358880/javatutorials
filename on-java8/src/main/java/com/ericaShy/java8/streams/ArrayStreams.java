package com.ericaShy.java8.streams;

import java.util.Arrays;

public class ArrayStreams {

    public static void main(String[] args) {
        Arrays.stream(new double[] {3.14159, 2.718, 1.618})
            .forEach(n -> System.out.format("%f ", n));

        System.out.println();
    }

}
