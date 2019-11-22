package com.ericaShy.java8.exceptions;

class ReException extends Exception {

    ReException(String message) {
        super(message);
    }
}

/**
 * printStackTrace()方法显示的是原来异常抛出点的调用
 */
public class Rethrowing {

    public static void f() throws Exception {
        System.out.println("originating the exception in f()");
        throw new Exception("throw from f()");
    }

    public static void g() throws Exception {
        try {
            f();
        } catch (Exception e) {
//            System.out.println("Inside g(), e.printStackTrace()");
//            e.printStackTrace(System.out);
            throw e;
        }
    }

    public static void h() throws Exception {
        try {
            f();
        } catch (Exception e) {
            throw (Exception) e.fillInStackTrace();
        }
    }


    public static void main(String[] args) throws Exception {
        try {
            g();
        } catch (Exception e) {
//            System.out.println("main: printStackTrace()");
            e.printStackTrace(System.out);
        }

        System.out.println("===================");

        try {
            h();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

}
