package com.ericaShy.java8.lowlevel;

public class UnsafeReturn extends IntTestable {
    private int i = 0;

    @Override
    synchronized void evenIncrement() {
        i++;
        i++;
//        System.out.println(Thread.currentThread().getName());
    }

    @Override
    public int getAsInt() {
        return i;
    }

    public static void main(String[] args) {
        Atomicity.test(new UnsafeReturn());
    }
}
