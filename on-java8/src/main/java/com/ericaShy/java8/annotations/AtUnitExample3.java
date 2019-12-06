package com.ericaShy.java8.annotations;

import com.ericaShy.java8.onjava.atunit.TestObjectCreate;

public class AtUnitExample3 {

    private int n;

    public AtUnitExample3(int n) {
        this.n = n;
    }

    public String methodOne() {
        return "This is methodOne";
    }

    public int methodTwo() {
        System.out.println("This is methodTwo");
        return 2;
    }

    @TestObjectCreate
    static AtUnitExample3 create() {
        return new AtUnitExample3(47);
    }

}
