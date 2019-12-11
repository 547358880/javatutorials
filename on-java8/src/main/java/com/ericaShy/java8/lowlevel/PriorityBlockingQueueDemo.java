package com.ericaShy.java8.lowlevel;

import java.util.List;
import java.util.SplittableRandom;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

class Prioritized implements Comparable<Prioritized> {
    private static AtomicInteger counter = new AtomicInteger();

    private final int id = counter.getAndIncrement();

    private final int priority;

    private static List<Prioritized> sequence = new CopyOnWriteArrayList<>();

    Prioritized(int priority) {
        this.priority = priority;
        sequence.add(this);
    }

    @Override
    public int compareTo(Prioritized o) {
        return priority < o.priority ? 1 : (priority > o.priority ? -1 : 0);
    }

    @Override
    public String toString() {
        return String.format("[%d] Prioritized %d", priority, id);
    }

    public void displaySequence() {
        int count = 0;
        for (Prioritized pt : sequence) {
            System.out.printf("(%d: %d)", pt.id, pt.priority);
            if (++count % 5 == 0) {
                System.out.println();
            }
        }
    }

    public static class EndSentinel extends Prioritized {
        EndSentinel() {
            super(-1);
        }
    }
}

class Producer implements Runnable {
    private static AtomicInteger seed = new AtomicInteger(47);
    private SplittableRandom rand = new SplittableRandom(seed.getAndAdd(10));

    @Override
    public void run() {

    }
}

public class PriorityBlockingQueueDemo {
}
