package com.ericaShy.java8.reuse;

/**
 * 类继承和初始化顺序
 */
class Insect {
    private int i = 9;
    protected int j;

    Insect() {
        System.out.println("i = " + i + ", j = " + j);
        j = 39;
    }

    private static int x1 = printInit("static Insect.x1 initialized");

    static int printInit(String s) {
        System.out.println(s);
        return 47;
    }
}

public class Beetle extends Insect {

    private int k = printInit("Beetle.k.initialized");

    public Beetle () {
        System.out.println("k = " + k);
        System.out.println("j = " + j);
    }

    private static int x2 = printInit("static Beetle.x2 initialized");

    /**
     * 加载过程:
     * 1. 当执行java Beetle时，首先会访问Beetle类的main方法, 加载器启动并找出Beetle类的编译代码(在名为Beetle.class的文件中),
     * 在加载过程中，编译器注意到一个基类，于是继续加载基类， 不论是否创建了对象，基类都会被加载
     * 2. 基类的static的初始化开始执行，接着是派生类, 接着可以创建对象了
     * 3. 对象创建后，首先对象中的所有基本类型变量都被置为默认值, 对象引用设置为null, 接着会调用基类构造器,当基类构造器完成后，
     * 实例变量按文本顺序初始化
     *
     * 输出:
     * static Insect.x1 initialized
     * static Beetle.x2 initialized
     * Beetle constructor
     * i=9, j=0
     * Beetle.k.initialized
     * k = 47
     * j = 39
     */
    public static void main(String[] args) {
        System.out.println("Beetle constructor");
        Beetle b = new Beetle();
    }
}
