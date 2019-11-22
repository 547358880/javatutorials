package com.ericaShy.java8.functional;

import java.util.function.Function;

/**
 *  柯里化意为：将一个多参数的函数，转换为一系列单参数函数
 */
public class CurringAndPartials {

    // 未柯里化
    static String uncurried(String a, String b) {
        return a + b;
    }

    /**
     * 输出
     * Hi Ho
     * Hi ho
     * Hup Ho
     * Hup Hey
     */
    public static void main(String[] args) {
        // 柯里化函数:
        Function<String, Function<String, String>> sum = a -> b -> a + b;

        System.out.println(uncurried("Hi ", "Ho"));

        Function<String, String> hi = sum.apply("Hi ");
        System.out.println(hi.apply("ho"));

        Function<String, String> sumHi = sum.apply("Hup ");
        System.out.println(sumHi.apply("Ho"));
        System.out.println(sumHi.apply("Hey"));
    }

}
