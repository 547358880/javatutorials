package com.ericaShy.java8.lowlevel;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 在主线程中使用try-catch代码捕获异常会不成功
 */
public class NaiveExceptionHandling {
    public static void main(String[] args) {
        ExecutorService es = Executors.newCachedThreadPool();
        try {
            es.execute(new ExceptionThread());
        } catch (RuntimeException ue) {
            // This statement will not execute!
            System.out.println("Exception was handled!");
        } finally {
            es.shutdown();
        }
    }
}
