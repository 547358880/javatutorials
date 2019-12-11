package com.ericaShy.java8.lowlevel;

import com.ericaShy.java8.onjava.Nap;
import com.sun.xml.internal.ws.util.CompletedFuture;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.stream.Collectors;

/**
 * 当权对象在不同锁上同步， 两个任务可以同时进入同一对象
 */
class DualSynch {
    ConcurrentLinkedQueue<String> trace = new ConcurrentLinkedQueue<>();

    public synchronized void f(boolean nap) {
        for (int i = 0; i < 5; i++) {
            trace.add(String.format("f() " + i));
            if (nap) new Nap(0.01);
        }
    }

    private Object syncObject = new Object();
    public void g(boolean nap) {
        synchronized (syncObject) {
            for (int i = 0; i < 5; i++) {
                trace.add(String.format("g() " + i));
                if (nap) new Nap(0.01);
            }
        }
    }
}

public class SyncOnObject {

    static void test(boolean fNap, boolean gNap) {
        DualSynch ds = new DualSynch();
        List<CompletableFuture<Void>> cfs =
                Arrays.stream(new Runnable[] {
                        () -> ds.f(fNap), () -> ds.g(gNap)
                }).map(CompletableFuture::runAsync)
                .collect(Collectors.toList());

        cfs.forEach(CompletableFuture::join);
        ds.trace.forEach(System.out::println);
    }

    public static void main(String[] args) {
        test(true, false);
        System.out.println("*****************");
        test(false, true);
    }
}
