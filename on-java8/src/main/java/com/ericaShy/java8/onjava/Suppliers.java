package com.ericaShy.java8.onjava;

import java.util.Collection;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Suppliers {

    //Create a collection and fill it
//    public static create(Supplier<C> factory. Supplier<T> gen, int n) {
//
//    }

    public static <T, C extends Collection<T>> C fill(C coll, Supplier<T> gen, int n) {
        Stream.generate(gen)
            .limit(n)
            .forEach(coll::add);
        return coll;
    }
}

