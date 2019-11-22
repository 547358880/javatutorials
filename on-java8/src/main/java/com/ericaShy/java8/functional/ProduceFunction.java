package com.ericaShy.java8.functional;

import java.util.function.Function;

interface FuncSS extends Function<String, String> {}

public class ProduceFunction {

    /**
     * 生成函数
     */
    static FuncSS produce() {
        return s -> s.toLowerCase();
    }

    public static void main(String[] args) {
        FuncSS f = produce();
        System.out.println(f.apply("YELLING"));
    }
}
