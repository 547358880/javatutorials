package com.ericaShy.java8.collections;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

/**
 * 任何实现了Iterable接口的类， 都能够使用for-in
 */
public class ForInCollections {

    public static void main(String[] args) {
        Collection<String> cs = new LinkedList<>();
        Collections.addAll(cs, "Take the long way home".split(" "));
        for (String s : cs) {
            System.out.print("'" + s + "' ");
        }
    }

}
