package com.ericaShy.java8.lowlevel;

import com.ericaShy.java8.onjava.TimedAbort;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 消费者任务EvenChecker
 * 消费者任务为检查偶数的有效性
 */
public class EvenChecker implements Runnable {
    private IntGenerator generator;

    private final int id;

    public EvenChecker(IntGenerator generator, int id) {
        this.generator = generator;
        this.id = id;
    }

    @Override
    public void run() {
//        System.out.println(Thread.currentThread().getName());
        while (!generator.isCanceled()) {
            int val = generator.next();
            if (val % 2 != 0) {
                System.out.println(val + " non even!");
                generator.cancel();     // Cancels all EvenCheckers
            }
        }
    }

    // Test any IntGenerator
    public static void test(IntGenerator gp, int count) {
        List<CompletableFuture<Void>> checkers = IntStream.range(0, count)
            .mapToObj(i -> new EvenChecker(gp, i))
            .map(CompletableFuture::runAsync)
            .collect(Collectors.toList());
        checkers.forEach(CompletableFuture::join);
    }

    public static void test(IntGenerator gp) {
        new TimedAbort(10, "No odd numbers discovered");
        test(gp, 10);
    }
}
