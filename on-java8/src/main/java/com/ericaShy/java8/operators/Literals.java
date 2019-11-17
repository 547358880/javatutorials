package com.ericaShy.java8.operators;

/**
 * 字面值常量(Literal)
 * 当向程序中插入一个字面值常量时， 编译器会确切的识别它的类型， 当类型不明确时， 必须辅以字面值常量关联来帮忙编译器识别
 */
public class Literals {

    public static void main(String[] args) {
        int i1 = 0x2f;  // 16进制
        System.out.println("i1: " + Integer.toBinaryString(i1));  // 0010 1111
        // 16进制无符号
        System.out.println("i1 hex:" + Integer.toHexString(i1));   // 2f

        int i2 = 0X2F;
        System.out.println("i2: " + Integer.toBinaryString(i2)); // 16进制 (大写)

        char c = 0xffff;  // 最大char型 16进制
        System.out.println("c: " + Integer.toBinaryString(c));      // c: 1111111111111111

        byte b = 0x7f;      // 最大byte型16进制 10101111
        System.out.println("b: " + Integer.toBinaryString(b));

        short s = 0x7fff;  //最大short型
        System.out.println("s: " + Integer.toBinaryString(s));      // s: 111111111111111

        // Java7 二进制字面量
        byte blb = (byte)0b00110101;
        System.out.println("blb: " + Integer.toBinaryString(blb));  // blb: 110101

        float f3 = 1f;
        double d1 = 1d;
    }

}
