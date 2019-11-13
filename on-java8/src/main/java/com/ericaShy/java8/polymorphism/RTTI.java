package com.ericaShy.java8.polymorphism;

/**
 * RTTI(运行时类型信息)
 *
 * Downcasting & Runtime type information (RTTI)
 */

class Useful {
    public void f() {}
    public void g() {}
}

class MoreUseful extends Useful {
    @Override
    public void f() {
        super.f();
    }

    @Override
    public void g() {
        super.g();
    }

    public void u() {}

    public void v() {}

    public void w() {}
}

public class RTTI {

    public static void main(String[] args) {
        Useful[] x = {
                new Useful(),
                new MoreUseful()
        };

        x[0].f();
        x[1].g();

        // Compile time: method not found in Useful:
        //- x[1].u();
        ((MoreUseful) x[1]).u(); // Downcast/RTTI
//        ((MoreUseful) x[0]).u(); // Exception thrown
    }
}
