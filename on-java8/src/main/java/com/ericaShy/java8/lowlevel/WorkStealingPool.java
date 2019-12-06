package com.ericaShy.java8.lowlevel;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

class ShowThread implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}

public class WorkStealingPool {

    public static void main(String[] args) throws InterruptedException {
        System.out.println(Runtime.getRuntime().availableProcessors());
        ExecutorService exec = Executors.newWorkStealingPool();
        IntStream.range(0, 20)
                .mapToObj(n -> new ShowThread())
                .forEach(exec::execute);

        System.out.println("3123");
        exec.awaitTermination(1, TimeUnit.SECONDS);
        System.out.println("dasd");
    }
}
