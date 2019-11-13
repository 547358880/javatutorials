package com.ericaShy.java8.housekepping;

/**
 * 可变参数
 */
class A{}

public class VarArgs {

    static void printArray(Object... args) {
        for (Object obj : args) {
            System.out.print(obj + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {
        printArray(47, (float) 3.14, 11.11);
        printArray(47, 3.14F, 11.11);
        printArray("one", "one", "one");
        printArray(new A(), new A(), new A());
        printArray((Object[]) new Integer[] {1, 2, 3, 4});
        printArray();
//        printArray(null);
    }
}
