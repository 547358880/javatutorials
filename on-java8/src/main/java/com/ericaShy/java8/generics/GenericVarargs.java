package com.ericaShy.java8.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenericVarargs {

    @SafeVarargs        // 注解保证不会对变长参数列表进行修改
    public static <T> List<T> makeList(T... args) {
        List<T> result = new ArrayList<>();
        for (T item : args) {
            result.add(item);
        }
        return result;
    }

    @SafeVarargs // No actually(实际上， 事实上) safe
    static void m(List<String>... stringLists) {
        Object[] array = stringLists;
        List<Integer> tmpList = Arrays.asList(42);
        array[0] = tmpList;
        String s = stringLists[0].get(0);   // ClassCastException at runtime
    }

    public static void main(String[] args) {
        List<String> ls = makeList("A");
        System.out.println(ls);

        ls = makeList("A", "B", "C");
        System.out.println(ls);

        ls = makeList("ABCDEFHIJKLMNOPQRSTUVWXYZ".split(""));
        System.out.println(ls);
    }
}
