package com.ericaShy.java8.exceptions;

class MyException2 extends Exception {
    private int x;

    MyException2() {}

    MyException2(String msg) {
        super(msg);
    }

    MyException2(String msg, int x) {
        super(msg);
        this.x = x;
    }

    public int val() {
        return x;
    }

    @Override
    public String getMessage() {
        return "Detail Message: " + x + " " + super.getMessage();
    }
}

public class ExtraFeatures {

}
