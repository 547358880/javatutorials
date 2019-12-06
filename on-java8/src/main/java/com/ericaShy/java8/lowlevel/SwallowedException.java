package com.ericaShy.java8.lowlevel;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 异常捕获
 */
public class SwallowedException {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService exec = Executors.newSingleThreadExecutor();
        exec.submit(() -> {
            throw new RuntimeException("exception 1");
        });

        exec.execute(() -> {
            throw new RuntimeException("exception 2");
        });
        exec.shutdown();
    }
}
