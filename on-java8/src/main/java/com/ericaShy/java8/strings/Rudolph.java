package com.ericaShy.java8.strings;

public class Rudolph {

    /**
     * true
     * true
     * true
     * true
     */
    public static void main(String[] args) {
        for(String pattern: new String[] {
            "Rudolph",
            "[rR]udolph",
            "[rR][aeiou][a-z]ol.*",
            "R.*"
        }) {
            System.out.println("Rudolph".matches(pattern));
        }
    }

}
