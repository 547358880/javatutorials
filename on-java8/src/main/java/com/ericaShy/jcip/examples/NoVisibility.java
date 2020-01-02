package com.ericaShy.jcip.examples;

/**
 * 可见性问题
 * P27
 * 会输出42或者0(指令重排)
 */
public class NoVisibility {

    private static boolean ready;
    private static int number;

    private static class ReadyThread extends Thread {
        public void run() {
            while (!ready) {
                Thread.yield();   // 也许无线循环,ready变量存在缓存一致性问题
            }
            System.out.println(number);
        }
    }

    public static void main(String[] args) {
        new ReadyThread().start();
        number = 42;
        ready = true;
    }
}
