package com.ericaShy.java8.onjava;

import java.util.Random;

public class Enums {
    private static Random rand = new Random(47);

    // T是一个enum实例
    public static <T extends Enum<T>> T random(Class<T> ec) {
        return random(ec.getEnumConstants());
    }

    public static <T> T random(T[] values) {
        return values[rand.nextInt(values.length)];
    }
}
