package com.ericaShy.java8.operators;

/**
 * 逻辑运算符的短路功能
 */
public class ShortCircuit {

    static boolean test1(int val) {
        System.out.println("test1(" + val + ")");
        System.out.println("result: " + (val < 1));
        return val < 1;
    }

    static boolean test2(int val) {
        System.out.println("test2(" + val + ")");
        System.out.println("result: " + (val < 2));
        return val < 2;
    }

    static boolean test3(int val) {
        System.out.println("test3(" + val + ")");
        System.out.println("result: " + (val < 3));
        return val < 3;
    }

    /**
     * 输出
     * test1(0)
     * result: true
     * test2(2)
     * result: false
     * false
     * ==========================
     * test1(2)
     * result: false
     * false
     */
    public static void main(String[] args) {
        boolean a = test1(0) && test2(2) && test3(2);
        System.out.println(a);

        System.out.println("==========================");
        boolean b = test1(2) && test2(1);
        System.out.println(b);
    }
}
