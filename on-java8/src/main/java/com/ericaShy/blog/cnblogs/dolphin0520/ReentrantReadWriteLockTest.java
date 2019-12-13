package com.ericaShy.blog.cnblogs.dolphin0520;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReentrantReadWriteLockTest {

    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public static void main(String[] args) {
        final ReentrantReadWriteLockTest test = new ReentrantReadWriteLockTest();

        new Thread() {
            @Override
            public void run() {
                test.get(Thread.currentThread());
            }
        }.start();

        new Thread(() -> {
            test.get(Thread.currentThread());
        }).start();
    }

    public void get(Thread thread) {
        lock.readLock().lock();

        try {

            long start = System.currentTimeMillis();
            System.out.println(thread.getName() + "正在进行读操作");
            try {
                Thread.sleep(5000);
            } catch (Exception e) {
            }
            System.out.println(thread.getName() + "读操作完毕");

        } finally {
            lock.readLock().unlock();
        }
    }

}
