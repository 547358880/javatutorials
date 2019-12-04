package com.ericaShy.java8.arrays;

import java.util.function.DoubleSupplier;

/**
 * 不能实例化参数化类型的数组
 * Peel<Banana>[] peels = new Peel<Banana>[10] // Illegal
 *
 * 但是可以创建对数组的引用
 * List<String>[] ls
 *
 * 类型擦除需要删除参数类型信息，而且数组必须知道它们所保存的确切类型，以强制保证类型安全。
 */

class ClassParameter<T> {
    public T[] f(T[] arg) {
        return arg;
    }
}

class MethodParameter {
    public static <T> T[] f(T[] arg) {
        return arg;
    }
}

public class ParameterizedArrayType {

    public static void main(String[] args) {
        Integer[] ints = {1, 2, 3, 4, 5};
        Double[] doubles = {1.1, 2.2, 3.3, 4.4, 5.5};
        Integer[] ints2 = new ClassParameter<Integer>().f(ints);
        Double[] doubles2 = new ClassParameter<Double>().f(doubles);

        ints = MethodParameter.f(ints);
        doubles = MethodParameter.f(doubles);
    }
}
