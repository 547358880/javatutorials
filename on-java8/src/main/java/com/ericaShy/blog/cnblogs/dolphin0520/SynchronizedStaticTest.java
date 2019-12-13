package com.ericaShy.blog.cnblogs.dolphin0520;

/**
 * 对象的synchronized和static的synchronized(类锁)
 */
public class SynchronizedStaticTest {

    /**
     * 输出
     * 执行Insert
     * 执行Insert1
     * 执行insert完毕
     * 执行insert1完毕
     * 执行Insert2
     * 执行insert2完毕
     */
    public static void main(String[] args) {
        InsertData insertData = new InsertData();
        new Thread(insertData::insert).start();
        new Thread(InsertData::insert1).start();
        new Thread(InsertData::insert2).start();
    }

    static class InsertData {

        public synchronized void insert() {
            System.out.println("执行Insert");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {}
            System.out.println("执行insert完毕");
        }

        public synchronized static void insert1() {
            System.out.println("执行Insert1");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {}
            System.out.println("执行insert1完毕");
        }

        public static void insert2() {
            synchronized (InsertData.class) {
                System.out.println("执行Insert2");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                }
                System.out.println("执行insert2完毕");
            }
        }
    }
}
