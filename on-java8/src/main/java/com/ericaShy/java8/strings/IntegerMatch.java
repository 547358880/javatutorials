package com.ericaShy.java8.strings;

public class IntegerMatch {

    public static void main(String[] args) {
        System.out.println("-1234".matches("-?\\d+")); // true
        System.out.println("5678".matches("-?\\d+")); // true
        System.out.println("+911".matches("-?\\d+"));   // false
        System.out.println("+911".matches("(-|\\+)?\\d+")); // true
    }

}
