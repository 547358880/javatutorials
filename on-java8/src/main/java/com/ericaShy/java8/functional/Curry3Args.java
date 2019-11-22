package com.ericaShy.java8.functional;

import java.util.function.Function;

public class Curry3Args {

    /**
     * 输出： Hi Ho Hup
     */
    public static void main(String[] args) {
        Function<String,
                Function<String,
                        Function<String, String>>> sum =
                            a -> b -> c -> a + b + c;

        Function<String, Function<String, String>> hi = sum.apply("Hi ");
        Function<String, String> ho = hi.apply("Ho ");
        System.out.println(ho.apply("Hup"));
    }

}
