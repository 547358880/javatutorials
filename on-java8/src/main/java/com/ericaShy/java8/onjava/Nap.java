package com.ericaShy.java8.onjava;

import java.util.concurrent.TimeUnit;

public class Nap {

    public Nap(double t) {      // Seconds
        try {
            TimeUnit.MILLISECONDS.sleep((int) (5000 * t));
        } catch (InterruptedException e) {
            throw  new RuntimeException(e);
        }
    }

    public Nap(double t, String msg) {
        this(t);
        System.out.println(msg);
    }

}
