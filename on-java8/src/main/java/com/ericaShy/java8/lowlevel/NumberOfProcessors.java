package com.ericaShy.java8.lowlevel;

/**
 * processor(处理器，处理程序)
 *
 * 查看当前机器上处理器的数量
 *
 */
public class NumberOfProcessors {

    public static void main(String[] args) {
        // 4
        System.out.println(Runtime.getRuntime().availableProcessors());
    }

}
