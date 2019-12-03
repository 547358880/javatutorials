package com.ericaShy.java8.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericsAndCovariance {

    public static void main(String[] args) {
        List<? extends Fruit> flist = new ArrayList<>();

        // Compile Error: cant't add any type of object
        //flist.add(new Apple());
        //flist.add(new Fruit());
        //flist.add(new Object());

        flist.add(null);

        // We know it returns at least Fruit
        Fruit f = flist.get(0);
    }

}
