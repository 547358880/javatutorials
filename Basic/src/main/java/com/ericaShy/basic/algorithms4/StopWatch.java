package com.ericaShy.basic.algorithms4;

/*
 *   A utility class to measure the running time of a program
 */
public class StopWatch {
    private final long start;

    /*
     * Initializes a new stopwatch
     */
    public StopWatch() {
        start = System.currentTimeMillis();
    }

    public double elapsedTime() {
        long now = System.currentTimeMillis();
        return (now - start) / 1000.0;
    }
}
