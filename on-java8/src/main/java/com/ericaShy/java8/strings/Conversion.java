package com.ericaShy.java8.strings;

import java.util.Formatter;

/**
 * Formatter转换
 * d 整型(十进制)
 * c Unicode字符
 * b Boolean值
 * s String
 * f 浮点数(十进制)
 * e 浮点数(科学计数)
 * x 整形(十六进制)
 * h 散列值(十六进制)
 * % 字面值%
 */
public class Conversion {
    public static void main(String[] args) {
        Formatter f = new Formatter(System.out);

        char u = 'a';
        System.out.println("u = 'a'");
        f.format("s: %s%n", u);
//        f.format("d: %d%n", u);
        f.format("c: %c%n", u);
    }

}
