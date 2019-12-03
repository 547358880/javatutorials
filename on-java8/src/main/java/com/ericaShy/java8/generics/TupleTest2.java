package com.ericaShy.java8.generics;

import com.ericaShy.java8.onjava.Tuple;
import com.ericaShy.java8.onjava.Tuple2;
import com.ericaShy.java8.onjava.Tuple3;
import com.ericaShy.java8.onjava.Tuple4;

import static com.ericaShy.java8.onjava.Tuple.tuple;

public class TupleTest2 {

    static Tuple2<String, Integer> f() {
        return tuple("hi", 47);
    }

    static Tuple2 f2() {
        return tuple("hi", 47);
    }

    static Tuple3<Amphibian, String, Integer> g() {
        return tuple(new Amphibian(), "hi", 47);
    }

    static Tuple4<Vehicle, Amphibian, String, Integer> h() {
        return tuple(new Vehicle(), new Amphibian(), "hi", 47);
    }
}
