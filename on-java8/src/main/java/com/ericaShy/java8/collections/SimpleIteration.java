package com.ericaShy.java8.collections;

import com.ericaShy.java8.typeinfo.pets.Pet;
import com.ericaShy.java8.typeinfo.pets.Pets;

import java.util.Iterator;
import java.util.List;

/**
 * 迭代器: 统一了对集合的访问方式
 */
public class SimpleIteration {

    public static void main(String[] args) {
        List<Pet> pets = Pets.list(12);
        Iterator<Pet> it = pets.iterator();
        while (it.hasNext()) {
            Pet p = it.next();
            System.out.print(p.id() + ": " + p + " ");
        }
    }
}
