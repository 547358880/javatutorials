package com.ericaShy.java8.collections;

// Simple collection use(suppressing compiler warnings)

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Apple {
    private static long counter;
    private final long id = counter++;
    public long id() { return id; }
}

class Orange {}

public class AppleAndOrangeWithoutGenerics {

    public static void main(String[] args) {
        System.out.println(System.getProperty("user.dir"));

        ArrayList apples = new ArrayList();
        for(int i = 0; i < 3; i++)
            apples.add(new Apple());
        // No problem adding an Orange to apples:
        apples.add(new Orange());

        System.out.println("dasdasd");

    }
}
