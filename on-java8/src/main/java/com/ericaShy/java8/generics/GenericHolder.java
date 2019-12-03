package com.ericaShy.java8.generics;

/**
 * T是类型参数
 */
public class GenericHolder<T> {

    private T a;

    public GenericHolder() {}

    public void set(T a) {
        this.a = a;
    }

    public T get() {
        return a;
    }

    public static void main(String[] args) {
        GenericHolder<Automobile> h3 = new GenericHolder<>();
        h3.set(new Automobile());       //  此处有类型校验
        Automobile a = h3.get();        // 无需类型转换
    }

}
