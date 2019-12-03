package com.ericaShy.java8.generics;

// {WillNotCompile}

/**
 * 因为擦除，我们将失去执行泛型代码中某些操作的能力, 无法在运行时知道确切类型
 */
public class Erased<T> {
    private final int SIZE = 100;

    public void f(Object arg) {
        // error: illegal generic type of instanceof
        //if (arg instanceof T) {}

        // error: unexpected(意外的,想不到的) type
        //T var = new T();

        // error: generic array creation
        //T[] array = new T[SIZE];

        // waring: [unchecked] unchecked cast
//        T[] array = (T[]) new Object[SIZE];
    }
}
