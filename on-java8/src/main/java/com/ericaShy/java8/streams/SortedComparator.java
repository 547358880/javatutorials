package com.ericaShy.java8.streams;

import java.util.Comparator;

/**
 * 流元素排序
 */
public class SortedComparator {

    public static void main(String[] args) throws Exception {
        FileToWords.stream(SortedComparator.class.getClassLoader().getResource("chess.dat").toURI())
            .skip(10)
            .limit(10)
            .sorted(Comparator.reverseOrder())
            .map(w -> w + " ")
            .forEach(System.out::print);
    }

}
