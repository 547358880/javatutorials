package com.ericaShy.java8.exceptions;

class ThreeException extends Exception {}

public class FinallyWords {

    static int count = 0;

    public static void main(String[] args) {
        while (true) {
            try {
                if (count++ == 0) {
                    System.out.println(count);
                    throw new ThreeException();
                }
                System.out.println("No exception");
            } catch (ThreeException e) {
                System.out.println("ThreeException");
            } finally {
                System.out.println("In finally clause");
                if (count == 2) break;
            }
        }
    }

}
