package com.ericaShy.java8.operators;

/**
 * 尝试转换float和double型数据为整形数据
 */
public class CastingNumbers {

    /**
     * byte 1字节
     * char 2字节
     * short 为2字节
     * float 类型数据长度为4字节
     * int 为4字节
     * double 为8字节
     * long 8字节
     */
    public static void main(String[] args) {
        double above = 0.7, below = 0.4;
        float fabove = 0.7f, fbelow = 0.4f;

        /**
         * 输出
         * (int)above: 0
         * (int)below: 0
         * (int)fabove: 0
         * (int)fbelow: 0
         */
        System.out.println("(int)above: " + (int) above);
        System.out.println("(int)below: " + (int) below);
        System.out.println("(int)fabove: " + (int) fabove);
        System.out.println("(int)fbelow: " + (int) fbelow);
    }
}
