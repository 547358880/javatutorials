package com.ericaShy.java8.housekepping;

public class OverloadingVarargs2 {

    static void f(float i, Character... args) {
        System.out.println("first");
    }

    static void f(Character... args) {
        System.out.println("second");
    }

    /**
     * 输出
     */
    public static void main(String[] args) {
//        f(1, 'a');
//        f('a', 'b');
    }
}
