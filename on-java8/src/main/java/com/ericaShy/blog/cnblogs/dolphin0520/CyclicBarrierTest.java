package com.ericaShy.blog.cnblogs.dolphin0520;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {

    public static void main(String[] args) {
        int N = 4;
        CyclicBarrier barrier = new CyclicBarrier(4);
        for (int i = 0; i < N; i++) {
            new Writer(barrier).start();
        }
    }

    static class Writer extends Thread {
        private CyclicBarrier cyclicBarrier;

        public Writer(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            System.out.println("线程" + Thread.currentThread().getName() + "正在写入数据...");
            try {
                Thread.sleep(5000);
                System.out.println("线程"+Thread.currentThread().getName()+"写入数据完毕，等待其他线程写入完毕");
                cyclicBarrier.await();
            } catch (Exception e) {
                e.printStackTrace();
            }

            System.out.println("所有线程写入完毕，继续处理其他任务...");
        }
    }

}
