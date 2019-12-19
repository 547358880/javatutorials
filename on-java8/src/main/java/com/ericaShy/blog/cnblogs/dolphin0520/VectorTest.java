package com.ericaShy.blog.cnblogs.dolphin0520;

import java.util.Vector;

/**
 * 同步容器不一定是安全的
 */
public class VectorTest {
    static Vector<Integer> vector = new Vector<>();

    /**
     * 有可能引发异常
     *
     * Exception in thread "Thread-3" java.lang.ArrayIndexOutOfBoundsException: Array index out of range: 30
     * 	at java.util.Vector.get(Vector.java:748)
     * 	at com.ericaShy.blog.cnblogs.dolphin0520.VectorTest.lambda$main$1(VectorTest.java:25)
     * 	at com.ericaShy.blog.cnblogs.dolphin0520.VectorTest$$Lambda$2/189568618.run(Unknown Source)
     * 	at java.lang.Thread.run(Thread.java:745)
     */
    public static void main(String[] args) {
        while (true) {
            for (int i = 0; i < 10; i++) {
                vector.add(i);
            }

            Thread thread1 = new Thread(() -> {
                for (int i = 0; i < vector.size(); i++) {
                    vector.remove(i);
                }
            });

            Thread thread2 = new Thread(() -> {
                for (int i = 0; i < vector.size(); i++) {
                    vector.get(i);
                }
            });

            thread1.start();
            thread2.start();

            if (Thread.activeCount() > 10) {
                break;
            }
        }
    }
}
