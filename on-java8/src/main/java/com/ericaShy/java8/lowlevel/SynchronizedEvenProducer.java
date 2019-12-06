package com.ericaShy.java8.lowlevel;

import com.ericaShy.java8.onjava.Nap;

public class SynchronizedEvenProducer extends IntGenerator {
    private int currentEvenValue = 0;

    @Override
    public synchronized int next() {
        ++currentEvenValue;
        new Nap(0.01);
        ++currentEvenValue;
        return currentEvenValue;
    }

    public static void main(String[] args) {
        EvenChecker.test(new SynchronizedEvenProducer());
    }
}
