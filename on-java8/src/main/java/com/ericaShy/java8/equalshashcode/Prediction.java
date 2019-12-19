package com.ericaShy.java8.equalshashcode;

import java.util.Random;

public class Prediction {
    private static Random random = new Random(47);

    @Override
    public String toString() {
        return random.nextBoolean() ? "Six more weeks of Winter!" : "Early Spring!";
    }
}
