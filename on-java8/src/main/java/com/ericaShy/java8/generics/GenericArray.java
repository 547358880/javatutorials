package com.ericaShy.java8.generics;

/**
 * 关联程序
 * com.ericaShy.java8.generics.ArrayOfGeneric
 * com.ericaShy.java8.generics.Erased
 */
public class GenericArray<T> {

    private T[] array;

    @SuppressWarnings("unckecked")
    public GenericArray(int sz) {
        array = (T[]) new Object[sz];
    }

    public void put(int index, T item) {
        array[index] = item;
    }

    // Method that exposes the underlying representation(代表；表现；表示法；陈述)
    public T[] rep() {
        return array;
    }

    public static void main(String[] args) {
        /**
         * 输出:
         * [Ljava.lang.Object; cannot be cast to [Ljava.lang.Integer;
         */
        GenericArray<Integer> gai = new GenericArray<>(10);
        try {
            Integer[] ia = gai.rep();
        } catch (ClassCastException e) {
            System.out.println(e.getMessage());
        }

        Object[] oa = gai.rep();
    }
}
