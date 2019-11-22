package com.ericaShy.java8.exceptions;

public class NeverCaught {

    static void f() {
        throw new RuntimeException("Form f()");
    }

    static void g() {
        f();
    }

    public static void main(String[] args) {
        g();
        System.out.println("dasdad");       // 不执行
    }

}


