package com.ericaShy.blog.cnblogs.dolphin0520;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockInterruptiblyTest {

    private Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        LockInterruptiblyTest test = new LockInterruptiblyTest();
        MyThread thread1 = new MyThread(test);
        MyThread thread2 = new MyThread(test);
        thread1.start();
        thread2.start();

        try {
//            Thread.sleep(2000);

            Thread.sleep(10000);
        } catch (InterruptedException e) {};

        thread2.interrupt();
    }

    public void insert(Thread thread) throws InterruptedException {
        lock.lockInterruptibly(); //注意，如果需要正确中断等待锁的线程，必须将获取锁放在外面，然后将InterruptedException抛出
        try {
            System.out.println(thread.getName() + "得到了锁");
            long startTime = System.currentTimeMillis();
//            for(    ;     ;) {
//                if(System.currentTimeMillis() - startTime >= Integer.MAX_VALUE)
//                    break;
//                //插入数据
//            }

            try {
                Thread.sleep(5000);
            } catch (Exception e) {};
        } finally {
            System.out.println(Thread.currentThread().getName()+"执行finally");
            lock.unlock();
            System.out.println(thread.getName()+"释放了锁");
        }
    }

    static class MyThread extends Thread {
        private LockInterruptiblyTest test;

        public MyThread(LockInterruptiblyTest test) {
            this.test = test;
        }

        @Override
        public void run() {
            try {
                test.insert(Thread.currentThread());
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + "被中断");
            }
        }
    }

}
