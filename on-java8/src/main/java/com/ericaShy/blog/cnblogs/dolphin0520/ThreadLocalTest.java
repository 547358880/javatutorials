package com.ericaShy.blog.cnblogs.dolphin0520;

import com.ericaShy.java8.onjava.atunit.Test;

public class ThreadLocalTest {

    ThreadLocal<Long> localLocal = new ThreadLocal<>();
    ThreadLocal<String> stringLocal = new ThreadLocal<>();

    public void set() {
        localLocal.set(Thread.currentThread().getId());
        stringLocal.set(Thread.currentThread().getName());
    }

    public long getLong() {
        return localLocal.get();
    }

    public String getString() {
        return stringLocal.get();
    }

    /**
     * 输出:
     * 1
     * main
     * 13
     * Thread-0
     * 1
     * main
     */
    public static void main(String[] args) throws Exception {
        final ThreadLocalTest test = new ThreadLocalTest();
        test.set();
        System.out.println(test.getLong());
        System.out.println(test.getString());
        Thread thread1 = new Thread(() -> {
            test.set();
            System.out.println(test.getLong());
            System.out.println(test.getString());
        });
        thread1.start();
        thread1.join();

        System.out.println(test.getLong());
        System.out.println(test.getString());
    }
}
