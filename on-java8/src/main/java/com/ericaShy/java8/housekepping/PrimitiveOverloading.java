package com.ericaShy.java8.housekepping;

/**
 * 重载和基本类型(Primitive)
 *
 * 基本类型可以从较小的类型转换成较大的类型
 *
 * 备注：当两个数值进行运算时：
 * 1. 如果两个操作数有一个是double类型，另外一个操作数就会转换为double类型
 * 2. 否则,如果其中一个操作数是float类型，另外一个操作数就会转换为float类型
 * 3. 否则，如果其中一个操作数是long类型， 另外一个操作数就会转换成long类型
 * 4. 否则，两个操作数都将被转换为int类型
 *
 */
public class PrimitiveOverloading {

    void f1(char x) {
        System.out.println("f1(char)");
    }

    void f1(byte x) {
        System.out.println("f1(byte)");
    }

    void f1(short x) {
        System.out.println("f1(short)");
    }

    void f1(int x) {
        System.out.println("f1(int)");
    }

    void f1(long x) {
        System.out.println("f1(long)");
    }

    void f1(float x) {
        System.out.println("f1(float)");
    }

    void f1(double x) {
        System.out.println("f1(double)");
    }

    void f2(byte x) {
        System.out.println("f2(byte)");
    }

    void f2(short x) {
        System.out.println("f2(short)");
    }

    void f2(int x) {
        System.out.println("f2(int)");
    }

    void f2(long x) {
        System.out.println("f2(long)");
    }

    void f2(float x) {
        System.out.println("f2(float)");
    }

    void f2(double x) {
        System.out.println("f2(double)");
    }

    void f3(short x) {
        System.out.println("f3(short)");
    }

    void f3(int x) {
        System.out.println("f3(int)");
    }

    void f3(long x) {
        System.out.println("f3(long)");
    }

    void f3(float x) {
        System.out.println("f3(float)");
    }

    void f3(double x) {
        System.out.println("f3(double)");
    }

    void f4(int x) {
        System.out.println("f4(int)");
    }

    void f4(long x) {
        System.out.println("f4(long)");
    }

    void f4(float x) {
        System.out.println("f4(float)");
    }

    void f4(double x) {
        System.out.println("f4(double)");
    }

    void f5(long x) {
        System.out.println("f5(long)");
    }

    void f5(float x) {
        System.out.println("f5(float)");
    }

    void f5(double x) {
        System.out.println("f5(double)");
    }

    void f6(float x) {
        System.out.println("f6(float)");
    }

    void f6(double x) {
        System.out.println("f6(double)");
    }

    void f7(double x) {
        System.out.println("f7(double)");
    }

    /**
     * 输出
     * f1(int)
     * f2(int)
     * f3(int)
     * f4(int)
     * f5(long)
     * f6(float)
     * f7(double)
     */
    void testCostVal() {
        System.out.println("testCostVal(5): ");
        f1(5);f2(5);f3(5);f4(5);f5(5);f6(5);f7(5);
        System.out.println();
    }

    /**
     * f1(char)
     * f2(int)
     * f3(int)
     * f4(int)
     * f5(long)
     * f6(float)
     * f7(double)
     */
    void testChar() {
        char x = 'x';
        System.out.println("testChar(" + x + "): ");
        f1(x);f2(x);f3(x);f4(x);f5(x);f6(x);f7(x);
        System.out.println();
    }

    /**
     * f1(byte)
     * f2(byte)
     * f3(short)
     * f4(int)
     * f5(long)
     * f6(float)
     * f7(double)
     */
    void testByte() {
        byte x = 0;
        System.out.println("testByte(" + x + "): ");
        f1(x);f2(x);f3(x);f4(x);f5(x);f6(x);f7(x);
        System.out.println();
    }

    /**
     * f1(short)
     * f2(short)
     * f3(short)
     * f4(int)
     * f5(long)
     * f6(float)
     * f7(double)
     */
    void testShort() {
        short x = 0;
        System.out.println("testShort(" + x + "): ");
        f1(x);f2(x);f3(x);f4(x);f5(x);f6(x);f7(x);
        System.out.println();
    }

    /**
     * f1(int)
     * f2(int)
     * f3(int)
     * f4(int)
     * f5(long)
     * f6(float)
     * f7(double)
     */
    void testInt() {
        int x = 0;
        System.out.println("testInt(" + x + "): ");
        f1(x);f2(x);f3(x);f4(x);f5(x);f6(x);f7(x);
        System.out.println();
    }

    /**
     * f1(long)
     * f2(long)
     * f3(long)
     * f4(long)
     * f5(long)
     * f6(float)
     * f7(double)
     */
    void testLong() {
        long x = 0;
        System.out.println("testLong(" + x + "): ");
        f1(x);f2(x);f3(x);f4(x);f5(x);f6(x);f7(x);
        System.out.println();
    }

    /**
     * f1(float)
     * f2(float)
     * f3(float)
     * f4(float)
     * f5(float)
     * f6(float)
     * f7(double)
     */
    void testFloat() {
        float x = 0;
        System.out.println("testFloat(" + x + "): ");
        f1(x);f2(x);f3(x);f4(x);f5(x);f6(x);f7(x);
        System.out.println();
    }

    /**
     * f1(double)
     * f2(double)
     * f3(double)
     * f4(double)
     * f5(double)
     * f6(double)
     * f7(double)
     */
    void testDouble() {
        double x = 0;
        System.out.println("testDouble(" + x + "): ");
        f1(x);f2(x);f3(x);f4(x);f5(x);f6(x);f7(x);
        System.out.println();
    }

    public static void main(String[] args) {
        PrimitiveOverloading p = new PrimitiveOverloading();
        p.testCostVal();
        p.testChar();
        p.testByte();
        p.testShort();
        p.testInt();
        p.testLong();
        p.testFloat();
        p.testDouble();
    }

}
