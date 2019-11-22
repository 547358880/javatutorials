package com.ericaShy.java8.functional;

import java.util.function.Function;

public class FunctionComposition {

    static Function<String, String> f1 = s -> {
        System.out.println(s);
        System.out.println("This is f1");
        return s.replace('A', '_');
    },
    f2 = s -> {
        System.out.println("This is f2");
        return s.substring(3);
    },
    f3 = s-> {
        System.out.println("This is f3");
        return s.toLowerCase();
    },
    f4 = f1.compose(f2).andThen(f3);
    // f2 -> f1 -> f3

    /**
     * 输出:
     * This is f2
     * AFTER ALL AMBULANCES
     * This is f1
     * This is f3
     * (_FTER _LL _MBUL_NCES)
     * _fter _ll _mbul_nces
     */
    public static void main(String[] args) {
        System.out.println(f4.apply("GO AFTER ALL AMBULANCES"));
    }
}
