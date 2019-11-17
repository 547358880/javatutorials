package com.ericaShy.java8.housekepping;

/**
 * 静态初始化块
 *
 * Explicit static initialization with "static" clause
 */
class Cup {
    Cup(int marker) {
        System.out.println("Cpu(" + marker + ")");
    }

    void f(int marker) {
        System.out.println("f(" + marker + ")");
    }
}

class Cups {
    static Cup cup1;
    static Cup cup2;

    static {
        cup1 = new Cup(1);
        cup2 = new Cup(2);
    }

    Cups() {
        System.out.println("Cups()");
    }
}

public class ExplicitStatic {
    /**
     * 输出
     * Cpu(1)
     * Cpu(2)
     * f(99)
     */
    public static void main(String[] args) {
        System.out.println("Inside main()");
        Cups.cup1.f(99);
    }
}
