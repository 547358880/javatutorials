package com.ericaShy.java8.lowlevel;

/**
 * 不是原子操作
 */
public class NotAtomic {

    int i;

    void f1() {
        i++;
    }

    void f2() {
        i += 3;
    }
}
