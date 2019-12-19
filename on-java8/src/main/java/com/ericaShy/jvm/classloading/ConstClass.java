package com.ericaShy.jvm.classloading;

public class ConstClass {
    static {
        System.out.println("ConstClass init!");
    }

    public static final String HELLOWORD = "hello world";
}
