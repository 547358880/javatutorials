package com.ericaShy.java8.lowlevel;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest extends IntTestable{
    private AtomicInteger i = new AtomicInteger(0);

    @Override
    void evenIncrement() {
        i.addAndGet(2);
    }

    @Override
    public int getAsInt() {
        return i.get();
    }

    public static void main(String[] args) {
        Atomicity.test(new AtomicIntegerTest());
    }
}
