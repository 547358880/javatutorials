package com.ericaShy.java8.functional;

import java.util.function.IntSupplier;

public class AnonymousClosure {

    IntSupplier makeFun(int x) {
        int i = 0;
        i++;
        return new IntSupplier() {
            @Override
            public int getAsInt() {
//                return x + i;     // i必须是final的
                return x;
            }
        };
    }
}
