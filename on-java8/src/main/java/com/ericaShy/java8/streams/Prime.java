package com.ericaShy.java8.streams;

import static java.util.stream.LongStream.*;

public class Prime {

    public static Boolean isPrime(long n) {
        return rangeClosed(2, (long) Math.sqrt(n))
                .noneMatch(i -> n % i == 0);
    }

}
