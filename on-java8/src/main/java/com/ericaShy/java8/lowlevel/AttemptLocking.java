package com.ericaShy.java8.lowlevel;

import com.ericaShy.java8.onjava.Nap;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class AttemptLocking {

    private ReentrantLock lock = new ReentrantLock();

    public void untimed() {
        boolean captured = lock.tryLock();
        try {
            System.out.println("tryLock(): " + captured);
        } finally {
            if (captured) {
                lock.unlock();
            }
        }
    }

    public void timed() {
        boolean captured = false;
        try {
            captured = lock.tryLock(2, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        try {
            System.out.println("tryLock(2, TimeUnit.SECONDS): " + captured);
        } finally {
            if (captured) {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        final AttemptLocking a1 = new AttemptLocking();
        a1.untimed();
        a1.timed();
        CompletableFuture.runAsync(() -> {
            a1.lock.lock();
            System.out.println("acquired");
        });

        new Nap(0.1);
        a1.untimed();
        a1.timed();
    }

}
