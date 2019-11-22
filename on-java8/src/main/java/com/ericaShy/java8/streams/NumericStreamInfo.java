package com.ericaShy.java8.streams;

import static com.ericaShy.java8.streams.RandInts.*;

public class NumericStreamInfo {

    public static void main(String[] args) {
        System.out.println(rands().average().getAsDouble());
        System.out.println(rands().max().getAsInt());
        System.out.println(rands().min().getAsInt());
        System.out.println(rands().sum());
        System.out.println(rands().summaryStatistics());
    }

}
