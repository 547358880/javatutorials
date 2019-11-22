package com.ericaShy.java8.functional;

/*
    未绑定的方法与多参数的结合使用
 */

class This {
    void two(int i, double d) {}
    void three(int i, double d, String s) {}
    void four(int i, double d, String s, char c) {}
}

interface TwoArgs {
    void call2(This athis, int i, double d);
}

interface ThreeArgs {
    void call3(This athis, int i, double d, String s);
}

public class MultiUnbound {

    public static void main(String[] args) {
        TwoArgs twoargs = This::two;
        ThreeArgs threeargs = This::three;

        This athis = new This();
        twoargs.call2(athis, 11, 3.14);
    }
}
