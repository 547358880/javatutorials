package com.ericaShy.java8.typeinfo;

import com.sun.org.apache.xml.internal.security.Init;

import java.util.Random;

/**
 * 类加载所经过的三个步骤:
 * 1. 加载, 这是由类加载器执行的,该步骤将查找字节码(通常在claasspath所指定的路径中查找), 并从这些字节中创建一个Class对象
 * 2. 链接, 在链接阶段将验证类中的字节码,为static字段分配存储空间，并且如果需要的话，将解析这个类创建的对其他类的所有引用
 * 3. 初始化, 如果该类具有超类，则先初始化超类， 执行static初始化器和static初始化块
 *
 * 备注:
 * 1.直到第一次引用一个static方法(构造器隐式地是static)或者非常量的static字段才会进行类初始化
 * 2.如果一个static字段不是final的,那么在对它访问时，总是要求在它被读取之前，要先进行链接(为这个字段分配存储空间)和初始化(初始化该存储空间)
 *
 *
 * 编译期常量(final static)：
 * 1. 必须是基本类型
 * 2. 必须在定义常量的时候进行符值
 */

class Initable {
    static final int STATIC_FINAL = 47;

    static final int STATIC_FINAL2 = ClassInitialization.rand.nextInt(1000);

    static {
        System.out.println("Initializing Initable");
    }
}

class Initable2 {
    static int staticNonFinal = 147;

    static {
        System.out.println("Initializing Initable2");
    }
}

class Initable3 {
    static int staticNonFinal = 74;
    static {
        System.out.println("Initializing Initable3");
    }
}

public class ClassInitialization {

    public static Random rand = new Random();

    /**
     * 输出:
     * After creating Initable ref
     * 47
     * Initializing Initable
     * 472
     * Initializing Initable2
     * 147
     * Initializing Initable3
     * After creating Initable3 ref
     * 74
     */
    public static void main(String[] args) throws Exception {
//        System.out.println(Initable.test);


        Class initable = Initable.class;
        System.out.println("After creating Initable ref");
        // Does not trigger initialization
        System.out.println(Initable.STATIC_FINAL);
        // Does triiger initalization
        System.out.println(Initable.STATIC_FINAL2);
        // does trigger initialization
        System.out.println(Initable2.staticNonFinal);
        Class initable3 = Class.forName("com.ericaShy.java8.typeinfo.Initable3");
        System.out.println("After creating Initable3 ref");
        System.out.println(Initable3.staticNonFinal);
    }

}
