package com.ericaShy.java8.housekepping;

/**
 * 可变参数如果列表没有任何元素，那么转变为大小为0的数组
 */
public class VarargType {

    static void f(Character... args) {
        System.out.print(args.getClass());
        System.out.println(" length " + args.length);
    }

    static void g(int... args) {
        System.out.println(args.getClass());
        System.out.println(" length " + args.length);
    }

    /**
     * 输出:
     * class [Ljava.lang.Character; length 1
     * class [Ljava.lang.Character; length 0
     * class [I
     *  length 1
     * class [I
     *  length 0
     * int[]: class [I
     */
    public static void main(String[] args) {
        f('a');
        f();
        g(1);
        g();
        System.out.println("int[]: " + new int[0].getClass());
    }
}
