package com.ericaShy.blog.cnblogs.dolphin0520;

import com.ericaShy.java8.onjava.TimedAbort;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TryLockTest {

    private ArrayList<Integer> arrayList = new ArrayList<>();
    private Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        final TryLockTest test = new TryLockTest();
        new Thread(() -> {
            test.insert(Thread.currentThread());
        }).start();

        new Thread(() -> {
            test.insert(Thread.currentThread());
        }).start();

        new TimedAbort(5);
        System.out.println("arraylist: " + test.arrayList);
    }

    public void insert(Thread thread) {
        if (lock.tryLock()) {
            try {
                System.out.println(thread.getName() + "等到了锁");
                for (int i = 0; i < 5; i++) {
                    arrayList.add(i);
                }

                Thread.sleep(3000);

            } catch (Exception e) {

            } finally {
                System.out.println(thread.getName() + "释放了锁");
                lock.unlock();
            }
        } else {
            System.out.println(thread.getName() + "获取锁失败");
        }
    }
}
