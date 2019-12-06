package com.ericaShy.java8.annotations;

import com.ericaShy.java8.onjava.atunit.Test;

public class AtUnitExample1 {

    public String methodOne() {
        return "This is methodOne";
    }

    @Test
    boolean methodOneTest() {
        return methodOne().equals("This is methodOne");
    }

    public static void main(String[] args) {
        String test1 = "1 + 1";
        String test2 = "System.out.println(123)";

        System.out.println(test1);
        System.out.println((test1));
    }
}
