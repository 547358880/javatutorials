package com.ericaShy.jvm.classloading;

/**
 * 通过子类引用父类的静态字段，不会导致子类初始化
 */

public class NotInitialization {
    /**
     * 输出:
     * SuperClass init!
     * 123
     */
    public static void main(String[] args) {
        System.out.println(SubClass.value);
    }
}
