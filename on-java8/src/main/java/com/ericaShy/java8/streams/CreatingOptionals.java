package com.ericaShy.java8.streams;

import java.util.Optional;

/**
 * 创建Optional
 *
 * empty(): 生成一个空Optional
 * of(value): 将一个非空值包装到Optional里
 * ofNullable(value): 针对一个可能为空的值， 为空时自动生成 Optional.empty，否则将值包装在 Optional 中
 *
 */
public class CreatingOptionals {

    static void test(String testName, Optional<String> opt) {
        System.out.println(" ===== " + testName + " ===== ");
        System.out.println(opt.orElse("Null"));
    }

    /**
     * 输出:
     * ===== empty =====
     * Null
     *  ===== of =====
     * Howdy
     * java.lang.NullPointerException
     *  ===== ofNullable =====
     * Hi
     *  ===== ofNullable =====
     * Null
     */
    public static void main(String[] args) {
        test("empty", Optional.empty());
        test("of", Optional.of("Howdy"));

        try {
            test("of", Optional.of(null));
        } catch (Exception e) {
            System.out.println(e);
        }

        test("ofNullable", Optional.ofNullable("Hi"));
        test("ofNullable", Optional.ofNullable(null));
    }
}
