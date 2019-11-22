package com.ericaShy.java8.exceptions;

public class ExceptionMethods {

    /**
     * 输出：
     * Caught Exception
     * getMessage():My Exception
     * getLocalizedMessage():My Exception
     * toString():java.lang.Exception: My Exception
     * printStackTrace():
     * java.lang.Exception: My Exception
     * 	at com.ericaShy.java8.exceptions.ExceptionMethods.main(ExceptionMethods.java:7)
     */
    public static void main(String[] args) {
        try {
            throw new Exception("My Exception");
        } catch (Exception e) {
            System.out.println("Caught Exception");
            System.out.println("getMessage():" + e.getMessage());
            System.out.println("getLocalizedMessage():" + e.getLocalizedMessage());
            System.out.println("toString():" + e);
            System.out.println("printStackTrace():");
            e.printStackTrace(System.out);
        }
    }

}
