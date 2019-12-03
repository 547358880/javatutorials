package com.ericaShy.java8.generics;

import java.util.ArrayList;
import java.util.List;

/**
 * 不可以创建泛型数组
 */
public class ArrayOfGeneric {
    static final int SIZE = 100;
    static Generic<Integer>[] gia;

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        /**
         * 输出:
         * [Ljava.lang.Object; cannot be cast to [Lcom.ericaShy.java8.generics.Generic;
         */
        try {
            gia = (Generic<Integer>[]) new Object[SIZE];
        } catch (ClassCastException e) {
            System.out.println(e.getMessage());
        }

        // Runtime type is the raw (erased(抹去；删除；擦掉（字迹）；消灭)) type
        gia = (Generic<Integer>[]) new Generic[SIZE];
        System.out.println(gia.getClass().getSimpleName());

        gia[0] = new Generic<>();
//        gia[1] = new Object();  // Compile-time error
        // Discovers type mismatch at compile time:
//        gia[2] = new Generic<Double>();

        Object[] test = gia;
        test[1] = new Generic<Double>();        // 不会报错

        List<String>[] lsa = new ArrayList[5];
        Object[] oa = lsa;
        List<Integer> li = new ArrayList<>();
        li.add(3);
        oa[1] = li;
//        String s = lsa[1].get(0);  //runtime  ClassCastException
    }
}
