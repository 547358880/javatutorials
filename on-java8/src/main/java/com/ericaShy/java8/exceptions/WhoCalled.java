package com.ericaShy.java8.exceptions;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/**
 * 栈的轨迹
 */
public class WhoCalled {

    static void f() {
        //Generate an exception to fill in the stack trace
        try {
            throw new Exception();
        } catch (Exception e) {
            for (StackTraceElement ste : e.getStackTrace()) {
                System.out.println(ste.getMethodName());
            }
        }
    }

    static void g() { f(); }

    static void h() { g(); }

    public static void main(String[] args) {
        f();
        System.out.println("**********");
        g();
        System.out.println("**********");
        h();
    }
}
