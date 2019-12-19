package com.ericaShy.blog.cnblogs.dolphin0520;

public class ThreadLocal1Test {

    /**
     * 重写initialValue可以不用先set
     */
    ThreadLocal<Long> localLocal = new ThreadLocal<Long>() {
        @Override
        protected Long initialValue() {
            return Thread.currentThread().getId();
        }
    };
    ThreadLocal<String> stringLocal = new ThreadLocal<String>() {
        @Override
        protected String initialValue() {
            return Thread.currentThread().getName();
        }
    };

    public void set() {
        localLocal.set(Thread.currentThread().getId());
        stringLocal.set(Thread.currentThread().getName());
    }

    public long getLong() {
        return localLocal.get();
    }

    public String getString() {
        return stringLocal.get();
    }

    /**
     * 输出:
     * 1
     * main
     * 13
     * Thread-0
     * 1
     * main
     */
    public static void main(String[] args) throws Exception {
        final ThreadLocal1Test test = new ThreadLocal1Test();
//        test.set();
        System.out.println(test.getLong());
        System.out.println(test.getString());

    }
}
