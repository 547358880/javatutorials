package com.ericaShy.java8.arrays;

import com.ericaShy.java8.generics.ArrayOfGeneric;

public class ArrayOfGenericType<T> {

    T[] array; //OK

    public ArrayOfGenericType(int size) {
        // error: generic array creation
        //- array = new T[size];

        array = (T[]) new Object[size];  //unchecked cast
    }

    // error: generic array creation
    // - public <U> U[] makeArray() { return new U[10]; }

}
