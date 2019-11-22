package com.ericaShy.java8.functional;

public class TriFunctionTest {

    static int f(int i, long l, double d) {
        return 99;
    }

    public static void main(String[] args) {
        TriFunction<Integer, Long, Double, Integer> tf = TriFunctionTest::f;
        System.out.println(tf.apply(10, 10L, 10D));

        tf = (i, l, d) -> 12;
    }

}
