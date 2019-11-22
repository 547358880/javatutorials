package com.ericaShy.java8.streams;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * 转换为数组
 * toArray(): 将流转换成适当类型的数组
 * toArray(generator)在特殊情况下，生成器用于分配自定义的数组存储
 */
public class RandInts {

    private static int[] rints = new Random(47).ints(0, 1000).limit(100).toArray();

    public static IntStream rands() {
        return Arrays.stream(rints);
    }

}
