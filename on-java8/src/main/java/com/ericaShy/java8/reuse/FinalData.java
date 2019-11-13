package com.ericaShy.java8.reuse;

import java.util.Random;

/**
 * 一个被static和final同时修饰的属性只会占用一段不能改变的存储空间
 */
class Value {
    int i;

    Value(int i) {
        this.i = i;
    }
}

public class FinalData {
    private static Random rand = new Random(47);
    private String id;

    public FinalData(String id) {
        this.id = id;
    }

    /**
     * Can be compile-time constants
     *
     * valueOne和VALUE_TWO都是带有编译时值的final基本类型，他们都可用做编译时常量
     * VALUE_THREE是一种更加典型的常量定义方式, public表示包外可以访问, static强调只有1个, final说明是一个常量
     */
    private final int valueOne = 9;
    private static final int VALUE_TWO = 99;

    public static final int VALUE_THREE = 39;

    /**
     * Cannot be compile-time constants
     */
    private final int i4 = rand.nextInt(20);
    private final int INT_5 = rand.nextInt(20);
    private Value v1 = new Value(11);
    private final Value v2 = new Value(22);
    private static final Value VAL_3 = new Value(3);
    private final int[] a = {1, 2, 3, 4, 5, 6};

    @Override
    public String toString() {
        return id + ": " + "i4= " + i4 + ", INT_5=" + INT_5;
    }

    public static void main(String[] args) {
        FinalData fd1 = new FinalData("fd1");
//        fd1.valueOne++;
    }
}
