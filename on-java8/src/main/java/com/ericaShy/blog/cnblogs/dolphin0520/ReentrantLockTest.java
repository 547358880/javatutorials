package com.ericaShy.blog.cnblogs.dolphin0520;

import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 可重入锁
 */
public class ReentrantLockTest {

    private ArrayList<Integer> arrayList = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        final ReentrantLockTest test = new ReentrantLockTest();

        new Thread() {
            @Override
            public void run() {
                test.insert(Thread.currentThread());
            }
        }.start();

        new Thread() {
            @Override
            public void run() {
                test.insert(Thread.currentThread());
            }
        }.start();

        Thread.sleep(5000);
        System.out.println("arrayList: " + test.arrayList);
    }

    /**
     * 输出:
     * Thread-1得到了锁
     * Thread-0得到了锁
     * Thread-0释放了锁
     * Thread-1释放了锁
     *
     * 原因: lock为局部变量
     */
    public void insert(Thread thread) {
        Lock lock = new ReentrantLock();
        lock.lock();
        try {
            System.out.println(thread.getName() + "得到了锁");
            try {Thread.sleep(3000); } catch (Exception e) {}
            for (int i = 0; i < 5; i++) {
                arrayList.add(i);
            }
        } finally {
            System.out.println(thread.getName() + "释放了锁");
            lock.unlock();
        }
    }
}
