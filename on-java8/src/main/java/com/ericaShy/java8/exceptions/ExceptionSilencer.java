package com.ericaShy.java8.exceptions;

class TestException extends Exception {}

public class ExceptionSilencer {

    static int f() throws Exception {
        try {
           System.out.println("1");
           throw new TestException();
        } catch (TestException e) {
            System.out.println("catch TestException");
            throw e;
        } finally {
            System.out.println("f() finally");
        }
    }

    public static void main(String[] args) throws Exception {

        /**
         * 输出
         * 1
         * catch TestException
         * f() finally
         */
        f();

//        int test = f();
        // 1
//        System.out.println(test);
    }

}
