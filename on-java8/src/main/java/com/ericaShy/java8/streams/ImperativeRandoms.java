package com.ericaShy.java8.streams;

import java.util.Random;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * 声明式编程(Declarative programming)是一种: 声明要做什么，而非怎么做的编程风格
 */
public class ImperativeRandoms {

    public static void main(String[] args) {
        Random rand = new Random(47);
        SortedSet<Integer> rints = new TreeSet<>();
        while (rints.size() < 7) {
            int r = rand.nextInt(20);
            if (r < 5) continue;
            rints.add(r);
        }

        System.out.println(rints);
    }

}
