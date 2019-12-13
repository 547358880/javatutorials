package com.ericaShy.blog.cnblogs.dolphin0520;

/**
 * 线程中断
 */
public class InterruptedTest {

    public static void main(String[] args) {
        InterruptedTest test = new InterruptedTest();
        MyThread thread = test.new MyThread();
        thread.start();
        try {
            Thread.currentThread().sleep(4000);
        } catch (InterruptedException e) {
            thread.interrupt();
        }
        thread.interrupt();
    }

    class MyThread extends Thread {
        @Override
        public void run() {
            int i = 0;
            while (!isInterrupted() && i < Integer.MAX_VALUE) {
                System.out.println(i + " while循环");
                i++;
            }
        }
    }
}
