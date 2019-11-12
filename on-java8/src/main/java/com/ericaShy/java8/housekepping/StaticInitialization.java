package com.ericaShy.java8.housekepping;

/**
 * 静态初始化顺序
 *
 * 创建对象的过程:
 * 1. 即使没有显式地使用static关键字，构造器实际上也是静态方法，所有当创建Dog类型的对象或是首次访问
 * Dog类的静态方法或属性时，Java解释器必须在类路径中查找，以定位Doc.class
 * 2. 当加载完Dog.class(创建一个Class对象)后, 有关静态初始化的所有动作都会执行，因此，静态初始化只会在
 * 首次加载Class对象时初始化一次
 * 3. 当使用new Dog()创建对象时, 首先会在堆上为Dog对象分配足够的存储空间
 * 4. 分配的存储空间首先会被清零, 即会将Dog对象中的所有基本类型数据设置为默认值(数字会被设置为0， 布尔值false), 引用会被置为null
 * 5. 执行多有出现在字段定义处的初始化动作
 * 6. 执行构造器
 */
class Bow1 {
    Bow1(int marker) {
        System.out.println("Bow1(" + marker + ")");
    }

    void f1(int marker) {
        System.out.println("f1(" + marker + ")");
    }
}

class Table {
    static Bow1 bow1 = new Bow1(1);

    Table() {
        System.out.println("Table()");
        bow2.f1(1);
    }

    void f2(int marker) {
        System.out.println("f2(" + marker + ")");
    }

    static Bow1 bow2 = new Bow1(2);
}

class Cupboard {
    Bow1 bow3 = new Bow1(3);
    static Bow1 bow4 = new Bow1(4);

    Cupboard() {
        System.out.println("Cupboard");
        bow4.f1(2);
    }

    void f3(int marker) {
        System.out.println("f3(" + marker + ")");
    }

    static Bow1 bowl5 = new Bow1(5);
}

public class StaticInitialization {

    /**
     * 输出
     * Bow1(1)
     * Bow1(2)
     * Table()
     * f1(1)
     * Bow1(4)
     * Bow1(5)
     * Bow1(3)
     * Cupboard
     * f1(2)
     * main creating new Cupboard()
     * Bow1(3)
     * Cupboard
     * f1(2)
     * main creating new Cupboard()
     * Bow1(3)
     * Cupboard
     * f1(2)
     * f2(1)
     * f3(1)
     */
    public static void main(String[] args) {
        System.out.println("main creating new Cupboard()");
        new Cupboard();
        System.out.println("main creating new Cupboard()");
        new Cupboard();
        table.f2(1);
        cupboard.f3(1);
    }

    static Table table = new Table();
    static Cupboard cupboard = new Cupboard();
}
