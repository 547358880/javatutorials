package com.ericaShy.java8.operators;

/**
 * 精度超出， 使内存溢出
 */
public class Overflow {

    public static void main(String[] args) {
        /**
         * 输出:
         * gib = 2147483647
         * bigger = -4
         */
        int big = Integer.MAX_VALUE;
        System.out.println("gib = " + big);
        int bigger = big * 4;
        System.out.println("bigger = " + bigger);
    }

}
