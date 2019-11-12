package com.ericaShy.java8.housekepping;

/**
 * 一旦显式地定义了构造器， 编译器就不会自动为你创建无参构造器
 */
class Bird2 {
    Bird2(int i) {
        System.out.println("int param " + i);
    }

    Bird2(double d) {
        System.out.println("double param " + d);
    }
}

public class NoSynthesis {

    /**
     * 输出：
     * int param 1
     * double param 1.0
     * double param 2.0
     */
    public static void main(String[] args) {
        //Bird2 b = new Bird2();  // No default
        Bird2 b2 = new Bird2(1);
        Bird2 b3 = new Bird2(1.0);
        Bird2 b4 = new Bird2(2.0f);
    }
}
