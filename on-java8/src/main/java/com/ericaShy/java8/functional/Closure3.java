package com.ericaShy.java8.functional;

import java.util.function.IntSupplier;

public class Closure3 {

    /**
     *
     * 编译出错
     * lambda表达式和匿名类，局部类使用局部变量时必须是final的
     */
    IntSupplier makeFunc(int x) {
        int i = 0;
//        return () -> x++ + i++;
        return null;
    }
}
