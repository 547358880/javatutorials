package com.ericaShy.java8.lowlevel;

import com.ericaShy.java8.onjava.Nap;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 显示使用Lock
 * 关联代码：
 * com.ericaShy.java8.lowlevel.SynchronizedEvenProducer
 */
public class MutexEvenProducer extends IntGenerator {

    private int currentEventValue = 0;
    private Lock lock = new ReentrantLock();

    @Override
    public int next() {
        lock.lock();
        try {
            ++currentEventValue;
            new Nap(0.01);
            ++currentEventValue;
            return currentEventValue;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        EvenChecker.test(new MutexEvenProducer());
    }
}
