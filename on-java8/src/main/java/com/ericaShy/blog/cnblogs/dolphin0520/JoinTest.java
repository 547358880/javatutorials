package com.ericaShy.blog.cnblogs.dolphin0520;

public class JoinTest {

    /**
     * 输出:
     * 进入线程main
     * 线程main等待
     * 进入线程Thread-0
     * 线程Thread-0执行完毕
     * 线程main继续执行
     */
    public static void main(String[] args) {
        System.out.println("进入线程" + Thread.currentThread().getName());
        JoinTest test = new JoinTest();
        MyThread thread1 = test.new MyThread();
        thread1.start();
        try {
            System.out.println("线程" + Thread.currentThread().getName() + "等待");
            thread1.join();
            System.out.println("线程" + Thread.currentThread().getName() + "继续执行");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("进入线程" + Thread.currentThread().getName());
            try {
                Thread.currentThread().sleep(5000);
            } catch (InterruptedException e) {

            }
            System.out.println("线程" + Thread.currentThread().getName() + "执行完毕");
        }
    }

}
