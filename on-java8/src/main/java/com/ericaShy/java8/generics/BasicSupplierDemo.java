package com.ericaShy.java8.generics;

import com.ericaShy.java8.onjava.BasicSupplier;

import java.util.stream.Stream;

public class BasicSupplierDemo {

    public static void main(String[] args) {
        Stream.generate(BasicSupplier.create(CountedObject.class))
                .limit(5)
                .forEach(System.out::println);

//        Stream.generate(BasicSupplierDemo::new)
//                .limit(5)
//                .forEach(System.out::println);
    }

}
