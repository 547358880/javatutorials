package com.ericaShy.java8.lowlevel;

import com.ericaShy.java8.onjava.Nap;
import com.ericaShy.java8.onjava.TimedAbort;

public class TestAbort {

    /**
     * 输出
     * Napping for 4
     * TimedAbort 1.0
     */
    public static void main(String[] args) {
        new TimedAbort(1);
        System.out.println("Napping for 4");
        new Nap(4);
    }

}
