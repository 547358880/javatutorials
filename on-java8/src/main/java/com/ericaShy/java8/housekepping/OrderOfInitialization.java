package com.ericaShy.java8.housekepping;

/**
 * 初始化顺序
 * 即使类变量散布在方法定义之间，它们会在任何方法（包括构造器）被调用之前得到初始化
 */

class Window {
    Window(int marker) {
        System.out.println("Window(" + marker + ")");
    }
}

class House {
    Window w1 = new Window(1);

    House() {
        System.out.println("House()");

        w3 = new Window(33);
    }

    Window w2 = new Window(2);

    void f() {
        System.out.println("f()");
    }

    Window w3 = new Window(3);
}

public class OrderOfInitialization {
    /**
     *
     * 输出:
     * Window(1)
     * Window(2)
     * Window(3)
     * House()
     * Window(33)
     * f()
     */
    public static void main(String[] args) {
        House h = new House();
        h.f();
    }
}
