package com.ericaShy.java8.lowlevel;

public class ExceptionThread implements Runnable {

    @Override
    public void run() {
        throw new RuntimeException();
    }
}
