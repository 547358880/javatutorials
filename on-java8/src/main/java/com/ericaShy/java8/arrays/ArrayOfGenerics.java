package com.ericaShy.java8.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayOfGenerics {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        List<String>[] ls;
        List[] la = new List[10];
        ls = (List<String>[]) la;  // Unchecked cast
        ls[0] = new ArrayList<>();

//        ls[1] = new ArrayList<Integer>();  //error

        // The problem: List<String> is a subtype of Object
        Object[] objects = ls;
        objects[1] = new ArrayList<>();

        // However, if your needs are straightforward it is
        // possible to create an array of generics, albeit
        // with an "unchecked cast" warning:
        List<BerylliumSphere>[] spheres =
                (List<BerylliumSphere>[])new List[10];
        Arrays.setAll(spheres, n -> new ArrayList<>());
    }
}
