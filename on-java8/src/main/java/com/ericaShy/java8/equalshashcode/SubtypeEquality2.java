package com.ericaShy.java8.equalshashcode;

import java.util.HashSet;
import java.util.Set;

class Dog2 extends Animal {

    Dog2(String name, Size size) {
        super(name, size);
    }

    @Override
    public boolean equals(Object rval) {
        return rval instanceof Dog2 && super.equals(rval);
    }
}

class Pig2 extends Animal {

    Pig2(String name, Size size) {
        super(name, size);
    }

    @Override
    public boolean equals(Object rval) {
        return rval instanceof Pig2 && super.equals(rval);
    }
}

public class SubtypeEquality2 {

    public static void main(String[] args) {
        /**
         * 输出:
         * Dog2[0]: Ralph MEDIUM 16add61
         * Pig2[1]: Ralph MEDIUM 16add61
         */
        HashSet<Animal> pets = new HashSet<>();
        pets.add(new Dog2("Ralph", Size.MEDIUM));
        pets.add(new Pig2("Ralph", Size.MEDIUM));
        pets.forEach(System.out::println);
    }



}
