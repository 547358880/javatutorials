package com.ericaShy.java8.strings;

import java.util.Objects;

/**
 * 字符串是不可变的
 */
public class Immutable {

    static class Test {

        @Override
        public int hashCode() {
            return 111;
        }
    }


    public static String upcase(String s) {
        return s.toUpperCase();
    }

    public static void main(String[] args) {
        String q = "howdy";

        Test test = new Test();
        System.out.println(Objects.hashCode(test));

        System.out.println(Objects.hashCode(q));

        System.out.println(Objects.hashCode(upcase(q)));
    }

}
