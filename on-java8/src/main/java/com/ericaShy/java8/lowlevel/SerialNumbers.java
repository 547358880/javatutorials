package com.ericaShy.java8.lowlevel;

public class SerialNumbers {

    private volatile int serialNumber = 0;

    public int nextSerialNumber() {
        return serialNumber++;  // Not thread-safe
    }

}
