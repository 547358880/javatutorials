package com.ericaShy.java8.housekepping;

/**
 *  初始化类成员变量
 */
public class InitialValues {

    boolean t;
    char c;
    byte b;
    short s;
    int i;
    long l;
    float f;
    double d;
    InitialValues reference;

    void printInitialValues() {
        System.out.println("Data type Initial value");
        System.out.println("boolean " + t);
        System.out.println("char[" + c + "]");
        System.out.println("byte " + b);
        System.out.println("short " + s);
        System.out.println("int " + i);
        System.out.println("long " + l);
        System.out.println("float " + f);
        System.out.println("double " + d);
        System.out.println("reference " + reference);
    }

    /**
     * 输出:
     * boolean false
     * char[ ]
     * byte 0
     * short 0
     * int 0
     * long 0
     * float 0.0
     * double 0.0
     * reference null
     */
    public static void main(String[] args) {
        new InitialValues().printInitialValues();
    }
}
