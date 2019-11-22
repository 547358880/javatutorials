package com.ericaShy.java8.functional;

import java.util.function.IntSupplier;

/**
 * 闭包的应用
 */
public class SharedStorage {

    public static void main(String[] args) {
        Closure3 c1 = new Closure3();
        IntSupplier f1 = c1.makeFunc(0);
        IntSupplier f2 = c1.makeFunc(0);
        IntSupplier f3 = c1.makeFunc(0);

        System.out.println(f1.getAsInt());
        System.out.println(f2.getAsInt());
        System.out.println(f3.getAsInt());
    }

}
