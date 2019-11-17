package com.ericaShy.java8.innerclasses;

// Creating a constructor for an anonymous inner class

abstract class Base {
    Base(int i) {
        System.out.println("Base constructor, i = " + i);
    }

    public abstract void f();
}

public class AnonymousConstructor {

    /**
     * 注: 这里的变量不要求一定是final的，因为被传递给匿名类的基类的构造器, 它并不会在匿名内部类被直接使用
     */
    public static Base getBase(int i) {
        return new Base(i) {
            {
                System.out.println("Inside instance initializer");
            }

            @Override
            public void f() {
                System.out.println("In anonymous f()");
            }
        };
    }

    /**
     * 输出:
     * Base constructor, i = 47
     * Inside instance initializer
     * In anonymous f()
     */
    public static void main(String[] args) {
        Base base = getBase(47);
        base.f();
    }
}
