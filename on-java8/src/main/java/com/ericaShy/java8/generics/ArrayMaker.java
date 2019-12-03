package com.ericaShy.java8.generics;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * 泛型不能用于显示地引用运行时类型的操作中，例如转型,instanceof操作和new表达式， 因为所有关于参数的类型信息都丢失了
 */
public class ArrayMaker<T> {
    private Class<T> kind;

    public ArrayMaker(Class<T> kind) {
        this.kind = kind;
    }

    @SuppressWarnings("unchecked")
    T[] create(int size) {
        return (T[]) Array.newInstance(kind, size);
    }

    public static void main(String[] args) {
        ArrayMaker<String> stringMaker = new ArrayMaker<>(String.class);
        String[] stringArray = stringMaker.create(9);
        System.out.println(Arrays.toString(stringArray));
    }
}
